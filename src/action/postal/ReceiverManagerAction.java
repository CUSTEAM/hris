package action.postal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import action.BaseAction;
import model.Message;
import model.POSTALMails;

public class ReceiverManagerAction extends BaseAction{
	
	public String Oid[], add_recDate, add_no[], add_username, add_from, add_stor, add_note, add_unit;
	public String que_begin, que_end, que_no, que_username, que_from, que_stor, que_note, que_unit;
	
	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	
	public String execute(){		
		request.setAttribute("ques", df.sqlGet("SELECT m.no, e1.cname as sigName, e.cname as recName, cm.name as storName FROM "
		+ "CODE_MAIL_STOR cm, POSTAL_mails m, empl e, wwpass w, empl e1, wwpass w1 WHERE w1.Oid=m.signer AND e1.idno=w1.username AND m.signer IS NOT NULL AND cm.id=m.stor AND m.username=w.Oid AND e.idno=w.username"));
		
		return SUCCESS;
	}
	
	public String search(){
		
		
		StringBuilder sql=new StringBuilder("SELECT cu.id as unitNo, cu.name as unitName, "
		+ "cd.id as deptNo, cd.name as deptName, m.recDate, m.no, m.fromr, e.cname, m.signer, "
		+ "m.signdate, m.rejectd, cm.name as storName FROM CODE_MAIL_STOR cm, POSTAL_mails m, wwpass w,"
		+ "(empl e LEFT OUTER JOIN CODE_UNIT cu ON e.unit_module=cu.id)LEFT OUTER JOIN CODE_DEPT cd ON e.unit=cd.id "
		+ "WHERE cm.id=m.stor AND e.idno=w.username AND "
		+ "m.username=w.Oid ");
		if(!que_no.equals(""))sql.append("AND m.no='"+que_no+"'");
		if(!que_username.equals(""))sql.append("AND m.username='"+que_username.substring(0, que_username.indexOf(","))+"'");
		if(!que_begin.equals(""))sql.append("AND m.recDate >='"+que_begin+"'");
		if(!que_end.equals(""))sql.append("AND m.recDate <='"+que_end+"'");
		
		sql.append("ORDER BY m.recDate DESC");
		
		
		request.setAttribute("mails", df.sqlGet(sql.toString()));
		request.setAttribute("unitMails", getUnitMails());
		
		return SUCCESS;
	}
	
	public String searchb(){
		
		
		return SUCCESS;
	}
	
	public String add(){
		
		if(add_username.equals("")&&add_unit.equals("")&&add_note.equals("")){
			Message msg=new Message();
			msg.setError("收件人不明確");
			this.savMessage(msg);
			return SUCCESS;
		}
		
		Date d=new Date();
		POSTALMails mail;
		for(int i=0; i<add_no.length; i++){
			
			mail=new POSTALMails();
			mail.setNo(add_no[i]);
			mail.setStor(add_stor);
			mail.setFromr(add_from);
			
			if(!add_username.equals("")){
				mail.setUsername(add_username.substring(0, add_username.indexOf(",")));
			}else{
				mail.setUnit(add_unit);
			}
			
			if(add_recDate.equals("")){
				mail.setRecDate(d);
			}else{
				try {
					mail.setRecDate(sf.parse(add_recDate));
				} catch (ParseException e) {
					mail.setRecDate(d);
				}
			}
			df.update(mail);
		}
		
		request.setAttribute("mails", df.sqlGet("SELECT cu.id as unitNo, cu.name as unitName, "
		+ "cd.id as deptNo, cd.name as deptName, m.recDate, m.Oid, m.no, m.fromr, e.cname, m.signer, "
		+ "m.signdate, m.rejectd, cm.name as storName FROM CODE_MAIL_STOR cm, POSTAL_mails m, wwpass w,"
		+ "(empl e LEFT OUTER JOIN CODE_UNIT cu ON e.unit_module=cu.id)LEFT OUTER JOIN CODE_DEPT cd ON e.unit=cd.id "
		+ "WHERE cm.id=m.stor AND e.idno=w.username AND m.username=w.Oid AND m.recDate >= '"+sf.format(d)+"' ORDER BY m.recDate DESC"));
		
		
		request.setAttribute("unitMails", getUnitMails());
		request.setAttribute("add", true);
		
		return SUCCESS;
	}
	
	public String sign(){
		
		for(int i=0; i<Oid.length; i++){
			System.out.println(Oid[i]);
		}
		
		
		return SUCCESS;
	}
	
	
	
	private <Map>List getUserMails(){
		
		
		
		return null;
	}
	
	private <Map>List getUnitMails(){
		
		StringBuilder sql=new StringBuilder(
		"SELECT cu.id as unitNo, cu.name as unitName, m.recDate, m.no, m.fromr, m.signer, "
		+ "m.signdate, m.rejectd, cm.name as storName FROM CODE_MAIL_STOR cm, POSTAL_mails m, "
		+ "CODE_UNIT cu WHERE cm.id=m.stor AND m.unit=cu.id AND m.recDate >= '2016-07-18' "
		+ "ORDER BY m.recDate DESC");
		
		
		
		
		return df.sqlGet(sql.toString());
	}
	

}
