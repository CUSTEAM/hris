package action.empl;

import java.util.List;
import java.util.Map;

import action.BaseAction;

public class EmplTechlimitAction extends BaseAction{
	
	public String techid, pcode, set, over_set, stay;
	public String[] time, time_over, time_stay, idno, Oid;
	
	public String execute(){		
		request.setAttribute("codes", df.sqlGet("SELECT * FROM CODE_EMPLROLETEACHER ORDER BY sequence"));		
		return SUCCESS;
	}
	
	public String search(){
		//String sql="SELECT (SELECT SUM(thour)FROM Dtime WHERE techid=e.idno AND Sterm='1')as term1,(SELECT SUM(thour)FROM Dtime WHERE techid=e.idno AND Sterm='2')as term2, (SELECT COUNT(*)FROM Empl_stay_info WHERE idno=e.idno)as stay,"
		String sql="SELECT (SELECT SUM(thour)FROM Dtime WHERE techid=e.idno AND Sterm='1')as thour, (SELECT COUNT(*)FROM Empl_stay_info WHERE idno=e.idno)as stay,"
		+ "t.Oid, t.time, t.time_over, t.time_stay, c.name, e.idno, e.sname, e.cname, e.unit, c5.name as unitname FROM "
		+ "((empl e LEFT OUTER JOIN Empl_techlimit t ON e.idno=t.idno)LEFT OUTER JOIN CODE_EMPLROLETEACHER c ON e.pcode=c.id)LEFT "
		+ "OUTER JOIN CODE_DEPT c5 ON c5.id=e.unit WHERE e.category='1'AND ";
		
		if(!techid.equals("")){
			sql+="e.Oid='"+techid+"'";
		}else{
			if(pcode.equals("")){
				sql+="e.pcode LIKE'%'";
			}else{
				sql+="e.pcode='"+pcode+"'";
			}
		}		
		sql+="ORDER BY e.unit";		
		request.setAttribute("empls", df.sqlGet(sql));		
		return execute();
	}
	
	public String save(){
		
		for(int i=0; i<idno.length; i++){			
			//System.out.println(idno[i]+", "+Oid[i]+", "+time[i]+", "+time_over[i]+", "+time_stay[i]);
			if(!Oid[i].equals("")){
				df.exSql("UPDATE Empl_techlimit SET time="+time[i]+", time_over="+time_over[i]+", time_stay="+time_stay[i]+" WHERE Oid="+Oid[i]);
				continue;
			}
			
			if(!time[i].equals("")||!time_over[i].equals("")||!time_stay.equals("")){
				if(time[i].equals(""))time[i]="0";
				if(time_over[i].equals(""))time_over[i]="0";
				if(time_stay[i].equals(""))time_stay[i]="0";
				df.exSql("INSERT INTO Empl_techlimit(idno,time,time_over,time_stay)VALUES('"+idno[i]+"',"+time[i]+","+time_over[i]+","+time_stay[i]+");");
			}			
		}		
		return search();
	}
}
