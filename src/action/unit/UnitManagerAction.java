package action.unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;

public class UnitManagerAction extends BaseAction{
	
	public String check[];
	public String campus[];
	public String pid[];
	public String name[];
	
	public String leader;
	public String nameno;
	
	public String id;
	public String sname;
	public String ename;
	public String location;
	public String phone;
	public String fax;
	public String website;
	public String email;
	
	public String assistant;
	public String military;
	public String ass;
	public String mil;
	
	public String execute(){
		
		Map unit;
		if(request.getParameter("uid")!=null){//2級單位
			unit=df.sqlGetMap("SELECT * FROM CODE_UNIT WHERE id='"+request.getParameter("uid")+"'");
			try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}	
			try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
			request.setAttribute("unit", unit);	
			return "editUnit";
		}
		
		if(request.getParameter("cid")!=null){//校區
			unit=df.sqlGetMap("SELECT * FROM CODE_CAMPUS WHERE id='"+request.getParameter("cid")+"'");
			try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}	
			try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
			request.setAttribute("unit", unit);
			return "editCampus";
		}
		
		if(request.getParameter("callege")!=null){//院
			unit=df.sqlGetMap("SELECT * FROM CODE_COLLEGE WHERE id='"+request.getParameter("callege")+"'");
			try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}	
			try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
			request.setAttribute("unit", unit);
			return "editCollege";
		}
		
		if(request.getParameter("dept")!=null){//系
			unit=df.sqlGetMap("SELECT * FROM CODE_DEPT WHERE id='"+request.getParameter("dept")+"'");
			try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("director")+"'");}catch(Exception e){}
			try{mil=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("military")+"'");}catch(Exception e){}	
			try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}	
			request.setAttribute("unit", unit);
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
		"',phone='"+phone+"',fax='"+fax+"',email='"+email+"',website='"+website+"',director='"+leader+"', assistant='"+assistant+"', military='"+military+"' WHERE id='"+id+"'");
		
		Map unit=df.sqlGetMap("SELECT * FROM CODE_DEPT WHERE id='"+id+"'");
		request.setAttribute("unit", unit);
		try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}
		try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
		try{mil=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("military")+"'");}catch(Exception e){}
		System.out.println(mil);
		return "editDept";
	}
	
	public String addUnit(){
		Map unit;
		int id;
		for(int i=0; i<check.length; i++){
			
			if(!check[i].equals("")){
				
				id=(df.sqlGetInt("SELECT id FROM CODE_UNIT ORDER BY id*1 DESC LIMIT 1"))+1;				
				
				df.exSql("INSERT INTO CODE_UNIT(id, campus, pid, name)VALUES" +
				"('"+id+"', '"+campus[i]+"', '"+pid[i]+"', '"+name[i]+"')");
				
				
				unit=df.sqlGetMap("SELECT * FROM CODE_UNIT WHERE id='"+id+"'");				
				request.setAttribute("unit", unit);
				return "editUnit";
			}
		}		
		return "editUnit";
	}	
	
	public String saveUnit(){
		
		
		
		if(pid[0].equals("")){pid[0]="0";}
		
		System.out.println(pid[0]+", "+id);
		
		df.exSql("UPDATE CODE_UNIT SET campus='"+campus[0]+"',pid='"+pid[0]+"',name='"+name[0]+"',sname='"+sname+"'," +
		"ename='"+ename+"',location='"+location+"',phone='"+phone+"',fax='"+fax+"',email='"+email+"',website='"+website+"'," +
		"leader='"+leader+"', assistant='"+assistant+"' WHERE id='"+id+"'");
		
		
		Map unit=df.sqlGetMap("SELECT * FROM CODE_UNIT WHERE id='"+id+"'");		
		
		
		try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}
		try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
		request.setAttribute("unit", unit);		
		
		
		
		
		return "editUnit";
	}
	
	public String saveCampus(){		
		df.exSql("UPDATE CODE_CAMPUS SET name='"+name[0]+"', address='"+ename+"', leader='"+leader+"', assistant='"+assistant+"' WHERE id='"+id+"'");
		Map unit=df.sqlGetMap("SELECT * FROM CODE_CAMPUS WHERE id='"+id+"'");
		request.setAttribute("unit", unit);
		try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}
		try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
		return "editCampus";
	}
	
	public String saveCollege(){
		df.exSql("UPDATE CODE_COLLEGE SET name='"+name[0]+"', ename='"+ename+
		"',phone='"+phone+"',fax='"+fax+"',email='"+email+"',website='"+website+"',leader='"+leader+"', assistant='"+assistant+"' WHERE id='"+id+"'");
		Map unit=df.sqlGetMap("SELECT * FROM CODE_COLLEGE WHERE id='"+id+"'");
		request.setAttribute("unit", unit);
		try{nameno=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("leader")+"'");}catch(Exception e){}
		try{ass=df.sqlGetStr("SELECT cname FROM empl WHERE idno='"+unit.get("assistant")+"'");}catch(Exception e){}
		return "editCollege";
	}

}
