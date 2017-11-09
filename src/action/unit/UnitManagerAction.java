package action.unit;

import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.CODE_UNIT;

public class UnitManagerAction extends BaseAction{
	
	public String check[],campus[],pid[],name[];	
	public String leader, id, sname, ename, location, phone, fax, website, email, assistant;
	
	public String execute(){
		
		if(request.getParameter("uid")!=null){//2級單位			
			request.setAttribute("unit", getLederOrAss(request.getParameter("uid"), "CODE_UNIT"));	
			return "editUnit";
		}
		
		if(request.getParameter("cid")!=null){//校區			
			request.setAttribute("unit", getLederOrAss(request.getParameter("cid"), "CODE_CAMPUS"));
			return "editCampus";
		}
		
		if(request.getParameter("callege")!=null){//院
			request.setAttribute("unit", getLederOrAss(request.getParameter("callege"), "CODE_COLLEGE"));
			return "editCollege";
		}
		
		if(request.getParameter("dept")!=null){//系
			request.setAttribute("unit", getLederOrAss(request.getParameter("dept"), "CODE_DEPT"));
			return "editDept";
		}
		
		//單位
		List<Map>allUnit=dm.sqlGet("SELECT id, name, e.cname as leader, e1.cname as assistant FROM (CODE_CAMPUS c LEFT OUTER JOIN empl e ON c.leader=e.idno)LEFT OUTER JOIN empl e1 ON e1.idno=c.assistant;");
		List<Map>tmp;		
		for(int i=0; i<allUnit.size(); i++){
			tmp=dm.sqlGet("SELECT id, name, e.cname as leader, e1.cname as assistant FROM (CODE_UNIT c LEFT OUTER JOIN empl e ON c.leader=e.idno)LEFT OUTER JOIN empl e1 ON e1.idno=c.assistant WHERE pid='0' AND campus='"+allUnit.get(i).get("id")+"'");			
			for(int j=0; j<tmp.size(); j++){				
				tmp.get(j).put("sub_unit", dm.sqlGet("SELECT id, name, e.cname as leader, e1.cname as assistant FROM (CODE_UNIT c LEFT OUTER JOIN empl e ON c.leader=e.idno)LEFT OUTER JOIN empl e1 ON e1.idno=c.assistant WHERE pid='"+tmp.get(j).get("id")+"'"));
			}			
			allUnit.get(i).put("unit", tmp);
		}
		request.setAttribute("aunit", allUnit);
		
		//院、系
		tmp=dm.sqlGet("SELECT id, name, e.cname as leader, e1.cname as assistant FROM (CODE_COLLEGE c LEFT OUTER JOIN empl e ON c.leader=e.idno)LEFT OUTER JOIN empl e1 ON e1.idno=c.assistant;");
		for(int i=0; i<tmp.size(); i++){
			tmp.get(i).put("dept", dm.sqlGet("SELECT id, name, e.cname as leader, e1.cname as assistant FROM (CODE_DEPT c LEFT OUTER JOIN empl e ON c.director=e.idno)LEFT OUTER JOIN empl e1 ON e1.idno=c.assistant WHERE college='"+tmp.get(i).get("id")+"'"));
		}
		request.setAttribute("colls", tmp);		
		return SUCCESS;
	}
	
	public String saveDept(){		
		df.exSql("UPDATE CODE_DEPT SET name='"+name[0]+"', ename='"+ename+
		"',phone='"+phone+"',fax='"+fax+"',email='"+email+"',website='"+website+"',director='"+getEmpleId(leader)+"', assistant='"+getEmpleId(assistant)+"'WHERE id='"+id+"'");
		request.setAttribute("unit", getLederOrAss(id, "CODE_DEPT"));
		return "editDept";
	}
	
	public String addUnit(){
		int id;
		for(int i=0; i<check.length; i++){
			
			if(!check[i].equals("")){
				
				id=(df.sqlGetInt("SELECT id FROM CODE_UNIT ORDER BY id*1 DESC LIMIT 1"))+1;				
				
				df.exSql("INSERT INTO CODE_UNIT(id, campus, pid, name)VALUES" +
				"('"+id+"', '"+campus[i]+"', '"+pid[i]+"', '"+name[i]+"')");
				
				request.setAttribute("unit", df.sqlGetMap("SELECT * FROM CODE_UNIT WHERE id='"+id+"'"));
				return "editUnit";
			}
		}		
		return "editUnit";
	}	
	
	public String saveUnit(){		
		CODE_UNIT c=new CODE_UNIT();
		c.setId(id);
		c.setCampus(campus[0]);
		c.setPid(pid[0]);
		c.setName(name[0]);
		c.setSname(sname);
		c.setEname(ename);
		c.setLocation(location);
		c.setPhone(phone);
		c.setFax(fax);
		c.setEmail(email);
		c.setWebsite(website);
		c.setLeader(getEmpleId(leader));
		c.setAssistant(getEmpleId(assistant));
		df.update(c);		
		request.setAttribute("unit", getLederOrAss(id, "CODE_UNIT"));		
		return "editUnit";
	}
	
	public String saveCampus(){		
		df.exSql("UPDATE CODE_CAMPUS SET name='"+name[0]+"', address='"+ename+"', leader='"+getEmpleId(leader)+"', assistant='"+getEmpleId(assistant)+"' WHERE id='"+id+"'");
		request.setAttribute("unit", getLederOrAss(id, "CODE_CAMPUS"));
		return "editCampus";
	}
	
	public String saveCollege(){		
		df.exSql("UPDATE CODE_COLLEGE SET name='"+name[0]+"', ename='"+ename+
		"',phone='"+phone+"',fax='"+fax+"',email='"+email+"',website='"+website+"',leader='"+getEmpleId(leader)+"', assistant='"+getEmpleId(assistant)+"' WHERE id='"+id+"'");
		request.setAttribute("unit", getLederOrAss(id, "CODE_COLLEGE"));
		return "editCollege";
	}
	
	private Map getLederOrAss(String id, String table){	
		String leader="leader";
		if(table.equals("CODE_DEPT"))leader="director";
		return df.sqlGetMap("SELECT e.Oid as leaderOid, e.cname as leaderName, e1.Oid as assOid, e1.cname as assName, cc.* FROM "
		+ "("+table+" cc LEFT OUTER JOIN empl e ON e.idno=cc."+leader+")LEFT OUTER JOIN empl e1 ON e1.idno=cc.assistant WHERE cc.id='"+id+"'");
	}
	
	private String getEmpleId(String emplOid){		
		if(emplOid.indexOf(",")>0){
			emplOid=emplOid.substring(0, emplOid.indexOf(","));
		}	
		
		if(emplOid.trim().length()>1){
			
			return df.sqlGetStr("SELECT idno FROM empl WHERE Oid="+emplOid);
		}else{
			return "";
		}
	}
}