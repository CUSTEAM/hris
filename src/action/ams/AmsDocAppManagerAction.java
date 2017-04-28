package action.ams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.AmsDocApply;
import model.Message;

public class AmsDocAppManagerAction extends BaseAction{
	public String sn, status, docType, askLeaveType, idno, startDate, endDate, totalDay, totalHour, 
	totalMinute, teachPeriod, agent, reason, memo;
	
	Message msg;
	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public String execute(){
		return SUCCESS;
	}
	
	private List<Map>getDocs(){
		
		StringBuilder sb=new StringBuilder("SELECT d.Oid, e.idno, e.cname, c.name as typeName, d.sn, "
		+ "(CASE d.status WHEN '0' THEN '不核准' WHEN '1' THEN '核准' ELSE '未處理' END) as statusName,d.startDate, d.endDate, d.totalDay, d.totalHour, d.totalMinute "
		+ "FROM AMS_DocApply d LEFT OUTER JOIN CODE_AMS_TYPE c ON c.id=d.askLeaveType, empl e WHERE "
		+ "d.idno=e.idno AND docType='"+docType+"'");
		
		/*if(!sn.equals("")){
			sb.append("AND d.sn='"+sn+"'");
			return df.sqlGet(sb.toString());
		}*/
		//if(!docType.equals(anObject))
		if(status.equals("n")){
			sb.append("AND d.status IS NULL ");
		}else{
			if(!status.equals(""))sb.append("AND d.status='"+status+"'");			
		}
		
		
		if(!askLeaveType.equals(""))sb.append("AND d.askLeaveType='"+askLeaveType+"'");
		if(!idno.equals(""))sb.append("AND e.idno='"+df.sqlGetStr("SELECT idno FROM empl WHERE Oid='"+idno.substring(0, idno.indexOf(","))+"'")+"'");
		if(!startDate.equals(""))sb.append("AND d.startDate>='"+startDate+"'");
		if(!endDate.equals(""))sb.append("AND d.endDate<='"+endDate+"'");
		if(!totalDay.equals(""))sb.append("AND d.totalDay='"+totalDay+"'");
		if(!totalHour.equals(""))sb.append("AND d.totalHour='"+totalHour+"'");
		if(!totalMinute.equals(""))sb.append("AND d.totalMinute='"+totalMinute+"'");
		if(!teachPeriod.equals(""))sb.append("AND d.teachPeriod='teachPeriod'");
		if(!agent.equals(""))sb.append("AND d.agent='"+df.sqlGetStr("SELECT idno FROM empl WHERE Oid='"+agent.substring(0, agent.indexOf(","))+"'")+"'");
		
		sb.append("ORDER BY d.startDate");
		//System.out.println(sb);
		return df.sqlGet(sb.toString());
	}
	
	private Map getDoc(){
		Map m=df.sqlGetMap("SELECT d.*, e.cname, e.Oid as emplOid, c.name as typeName FROM "
		+ "AMS_DocApply d LEFT OUTER JOIN CODE_AMS_TYPE c ON c.id=d.askLeaveType, empl e WHERE e.idno=d.idno AND d.sn="+sn);
		
		//if(m.get("agent")!=null&& !m.get("agent").equals(""))
		try{
			m.putAll(df.sqlGetMap("SELECT Oid as agent, cname as agentName FROM empl WHERE idno='"+m.get("agent")+"'"));
		}catch(Exception e){
			
		}
		
		return m;
	}
	
	public String snSearch(){	
		
		if(sn.equals("")){
			sn=request.getParameter(sn);
		}
		Map m=getDoc();		
		if(m==null){
			msg=new Message();
			msg.setError("無對應資料<script>setTimeout(window.close,2000);</script>");
			this.savMessage(msg);
			return SUCCESS;
		}
		request.setAttribute("doc", m);		
		return SUCCESS;
	}
	
	public String add() throws ParseException{
		msg=new Message();
		if(docType.equals("1")){
			if(askLeaveType.equals("")){
				msg.setError("假別不可為空白");
				this.savMessage(msg);
				return SUCCESS;
			}
		}else{
			if(!askLeaveType.equals("")){
				msg.setError("假別必須為空白");
				this.savMessage(msg);
				return SUCCESS;
			}
		}
		if(idno.indexOf(",")<1){
			msg.setError("申請人不可為空白");
			this.savMessage(msg);
			return SUCCESS;
		}
		if(startDate.indexOf(":")<1){
			msg.setError("開始日期不可為空白");
			this.savMessage(msg);
			return SUCCESS;
		}
		if(endDate.indexOf(":")<1){
			msg.setError("結束日期不可為空白");
			this.savMessage(msg);
			return SUCCESS;
		}
		if(totalDay.equals("")||totalHour.equals("")||totalMinute.equals("")){
			msg.setError("日、時、分不可為空白");
			this.savMessage(msg);
			return SUCCESS;
		}
		Date now=new Date();
		AmsDocApply a=new AmsDocApply();
		if(agent.indexOf(",")>0)
		a.setAgent(df.sqlGetStr("SELECT idno FROM empl WHERE Oid="+agent.substring(0, agent.indexOf(","))));
		if(!askLeaveType.equals("")){
			a.setAskLeaveType(askLeaveType);
		}
		a.setSent("0");
		a.setSn(String.valueOf(now.getTime()));
		a.setCreateDate(now);
		a.setDocType(docType);
		a.setIdno(df.sqlGetStr("SELECT idno FROM empl WHERE Oid="+idno.substring(0, idno.indexOf(","))));	
		a.setEndDate(sf.parse(endDate));		
		a.setStartDate(sf.parse(startDate));		
		a.setMemo(memo);
		a.setReason(reason);
		if(!status.equals("")){
			a.setStatus(status);
		}		
		if(!teachPeriod.equals(""))a.setTeachPeriod(Integer.parseInt(teachPeriod));
		if(!totalDay.equals(""))a.setTotalDay(Integer.parseInt(totalDay));
		if(!totalHour.equals(""))a.setTotalHour(Integer.parseInt(totalHour));
		if(!totalMinute.equals(""))a.setTotalMinute(Integer.parseInt(totalMinute));
		a.setChief(getSession().getAttribute("userid").toString());
		try{
			df.update(a);
			msg.setSuccess("已新增假單"+a.getSn());
			this.savMessage(msg);
			return search();
		}catch(Exception e){
			msg.setError("新增失敗");
			this.savMessage(msg);
			return search();
		}
		
		
		
		
	}
	
	public String search(){
		msg=new Message();		
		List l=getDocs();		
		if(l.size()<1){
			msg.setError("無對應資料");
			this.savMessage(msg);
			return SUCCESS;
		}
		request.setAttribute("docs", l);		
		return SUCCESS;
	}
	
	public String edit(){
		
		
		return SUCCESS;
	}
	
	public String save() throws ParseException{
		Message msg=new Message();
		
		//AmsDocApply a=new AmsDocApply();
		AmsDocApply a=(AmsDocApply) df.hqlGetListBy("FROM AmsDocApply WHERE sn='"+sn+"'").get(0);
		
		if(agent.indexOf(",")>0)
		a.setAgent(df.sqlGetStr("SELECT idno FROM empl WHERE Oid="+agent.substring(0, agent.indexOf(","))));
		if(askLeaveType.equals("")){
			if(a.getDocType().equals("1")){
				msg.setError("請假需要假別");
				this.savMessage(msg);
				return snSearch();
			}
		}else{
			a.setAskLeaveType(askLeaveType);
		}
		//SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");			
		a.setEndDate(sf.parse(endDate));		
		a.setStartDate(sf.parse(startDate));		
		a.setMemo(memo);
		a.setReason(reason);
		if(status.equals("")){
			a.setStatus(null);
		}else{
			a.setStatus(status);
		}
		
		if(!teachPeriod.equals(""))a.setTeachPeriod(Integer.parseInt(teachPeriod));
		if(!totalDay.equals(""))a.setTotalDay(Integer.parseInt(totalDay));
		if(!totalHour.equals(""))a.setTotalHour(Integer.parseInt(totalHour));
		if(!totalMinute.equals(""))a.setTotalMinute(Integer.parseInt(totalMinute));
		a.setChief(getSession().getAttribute("userid").toString());
		df.update(a);
		msg.setSuccess("已儲存");
		this.savMessage(msg);
		return snSearch();
	}
	
	public String del(){
		msg=new Message();
		df.exSql("DELETE FROM AMS_DocApply WHERE sn='"+sn+"'");
		msg.setSuccess("已刪除"+sn);
		this.savMessage(msg);
		return search();
	}

}
