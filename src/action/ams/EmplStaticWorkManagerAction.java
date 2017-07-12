package action.ams;

import action.BaseAction;

public class EmplStaticWorkManagerAction extends BaseAction{
	public String shift, shifts, idno, unit, unitModule, Oid[], wshift[];
	public String execute(){
		
		request.setAttribute("shifts", df.sqlGet("SELECT id, name, in1, out1 FROM AMS_ShiftTime"));
		request.setAttribute("units", df.sqlGet("SELECT id, name, sname FROM CODE_UNIT"));
		
		
		return SUCCESS;
	}
	
	public String save(){
		
		
		for(int i=0; i<Oid.length; i++){
			
			if(!Oid[i].equals("")){
				//if()
				df.exSql("UPDATE empl SET WorkShift='"+wshift[i]+"' WHERE Oid="+Oid[i]);
			}
			
			
		}
		
		
		return search();
	}

	public String search(){
		
		StringBuilder sql=new StringBuilder("SELECT e.sname,c.id, c.name as unitName, c1.name as unitModule, "
				+ "e.cname, e.Oid, e.WorkShift FROM(empl e LEFT OUTER JOIN CODE_UNIT "
				+ "c ON e.unit=c.id)LEFT OUTER JOIN CODE_UNIT c1 ON e.unit_module=c1.id WHERE e.cname IS NOT NULL ");
		if(!shift.equals("all"))sql.append("AND e.WorkShift='"+shift+"'");
		if(!unit.equals(""))sql.append("AND e.unit='"+unit+"'");
		if(idno.indexOf(",")>0)sql.append("AND e.Oid ="+idno.substring(0, idno.indexOf(",")));
		if(!unitModule.equals(""))sql.append("AND e.unit_module='"+unitModule+"'");
		System.out.println(sql);
		request.setAttribute("empls", df.sqlGet(sql.toString()));
		
		
		return execute();
	}
}
