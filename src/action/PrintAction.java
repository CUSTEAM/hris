package action;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.print.BirthPrint;
import action.print.RetirePrint;
import action.print.StayTimePrint;

public class PrintAction extends BaseAction{
	//修改次數
	List<Map>edit;
	
	//未填寫
	List<Map>none;
	
	//不足
	List<Map>enough;
	
	//星期
	List<Map>empls;
	Map info;
	Date staytime_begin;
	Date staytime_end;
	
	public String execute(){
		
		
		return SUCCESS;
	}
	
	/**
	 * 課後輔導時間
	 * @return
	 * @throws IOException 
	 */
	public String StayTimePrint() throws IOException{		
		info=new HashMap();
		info.put("school_year", getContext().getAttribute("school_year"));
		info.put("school_term", getContext().getAttribute("school_term"));		
		staytime_begin=(Date)getContext().getAttribute("date_staytime_begin");
		staytime_end=(Date)getContext().getAttribute("date_staytime_end");
		getInfo("1");		
		StayTimePrint p=new StayTimePrint(response, "1", none, edit, empls, enough, df.sqlGet("SELECT * FROM Empl_stay_info WHERE kind='1' ORDER BY week, period"), info);
		p.print();
		
		return null;
	}
	
	/**
	 * 生活輔導時間
	 * @return
	 * @throws IOException 
	 */
	public String StayTimePrintLife() throws IOException{		
		info=new HashMap();
		info.put("school_year", getContext().getAttribute("school_year"));
		info.put("school_term", getContext().getAttribute("school_term"));		
		staytime_begin=(Date)getContext().getAttribute("date_staytime_begin");
		staytime_end=(Date)getContext().getAttribute("date_staytime_end");
		getInfo("2");		
		StayTimePrint p=new StayTimePrint(response, "2", none, edit, empls, enough, df.sqlGet("SELECT * FROM Empl_stay_info WHERE kind='2' ORDER BY week, period"), info);
		p.print();
		return null;
	}	
	
	private void getInfo(String kind){		
		//修改次數
		edit=df.sqlGet("SELECT (SELECT COUNT(*)FROM Empl_stay_hist WHERE idno=e.idno AND edate>='"+getContext().getAttribute("staytime_end")+"')as cnt, e.cname, cd.name as dname, "
		+ "cu.name as uname, e.sname, MAX(esh.edate) as edate FROM ((empl e LEFT OUTER JOIN Empl_stay_hist esh ON e.idno=esh.idno)LEFT OUTER JOIN "
		+ "CODE_DEPT cd ON e.unit=cd.id)LEFT OUTER JOIN CODE_UNIT cu ON e.unit=cu.id WHERE e.category='1' GROUP BY e.idno ORDER BY e.unit");
		//未填寫
		if(kind.equals("1")){
			none=df.sqlGet("SELECT e.cname, e.sname, cd.name as dname, e.CellPhone, e.Email FROM"
			+ "(empl e LEFT OUTER JOIN CODE_DEPT cd ON e.unit=cd.id) WHERE e.category='1'AND "
			+ "e.idno NOT IN(SELECT idno FROM Empl_stay_info WHERE kind='"+kind+"' AND school_term='"
			+getContext().getAttribute("school_term")+"' AND school_year='"+getContext().getAttribute("school_year")
			+"')AND e.idno NOT IN(SELECT idno FROM Empl_techlimit WHERE time_stay>=time)ORDER BY e.unit, e.idno");
		}else{
			none=df.sqlGet("SELECT e.cname, e.sname, cd.name as dname, e.CellPhone, e.Email FROM Class z,"
			+ "(empl e LEFT OUTER JOIN CODE_DEPT cd ON e.unit=cd.id) WHERE z.Type='P'AND z.tutor=e.idno AND e.category='1'AND "
			+ "e.idno NOT IN(SELECT idno FROM Empl_stay_info WHERE kind='"+kind+"' AND school_term='"
			+getContext().getAttribute("school_term")+"' AND school_year='"+getContext().getAttribute("school_year")
			+"')GROUP BY z.tutor ORDER BY e.unit, e.idno");
		}		
		//不足 t=扣除時數, s=應設上限, r=實設時數
		if(kind.equals("1")){
			enough=df.sqlGet("SELECT e.cname, e.sname, d.name as dname, e.CellPhone, e.Email,"
			+ "IFNULL(time_stay,0)as t, IFNULL(( SELECT time FROM Empl_techlimit WHERE idno=et.idno),0)as s,"
			+ "(SELECT COUNT(*)FROM Empl_stay_info WHERE idno=e.idno AND school_term='"+
			getContext().getAttribute("school_term")+"' AND school_year='"+getContext().getAttribute("school_year")+"')as r "
			+ "FROM (empl e LEFT OUTER JOIN Empl_techlimit et ON e.idno=et.idno)"
			+ "LEFT OUTER JOIN CODE_DEPT d ON d.id=e.unit WHERE e.category='1'ORDER BY e.unit, e.idno");
		}else{
			enough=df.sqlGet("SELECT e.idno, e.cname, e.sname, d.name as dname, e.CellPhone,e.Email,0 as t,"
			+ "IFNULL(( SELECT COUNT(*) FROM Class WHERE tutor=e.idno AND Type='P'),0)as s,"
			+ "(SELECT COUNT(*)FROM Empl_stay_info WHERE  idno=e.idno AND kind='2' AND school_year='"+getContext().getAttribute("school_year")+"' AND school_term='"+getContext().getAttribute("school_term")+"')as r "
			+ "FROM empl e LEFT OUTER JOIN CODE_DEPT d ON d.id=e.unit WHERE e.category='1'ORDER BY e.unit, e.idno");
		}		
		//星期
		empls=df.sqlGet("SELECT e.idno, cd.name as dname, e.cname, esp.contact, e.CellPhone, esp.place FROM"
		+ "(empl e LEFT OUTER JOIN Empl_stay_place esp ON e.idno=esp.idno)"
		+ "LEFT OUTER JOIN CODE_DEPT cd ON e.unit=cd.id WHERE e.category='1'ORDER BY e.unit, e.idno");		
	}
	
	
	
	/**
	 * 退撫
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
 	public String RetirePrint() throws IOException, ParseException{		
		RetirePrint p=new RetirePrint(response, df.sqlGet("SELECT s.sno,e.idno,e.cname,e.bdate,e.czip,e.caddr,e.telephone,"
		+ "e.CellPhone,IFNULL(e.Email,'')as Email FROM empl e LEFT OUTER JOIN salyset s ON e.idno=s.set_idno "
		+ "WHERE e.category!='2' AND e.pcode NOT IN('60', '601', '602') ORDER BY e.category,s.sno"));
		p.print();		
		return null;
	}
	
	/**
	 * 慶生
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String BirthPrint() throws IOException, ParseException{
		BirthPrint p=new BirthPrint(response, df.sqlGet("SELECT IFNULL(e.Email,'')as Email, e.cname, d.name as dname, u.name as uname, e.sname, e.bdate FROM "
		+ "((empl e LEFT OUTER JOIN salyset s ON e.idno=s.set_idno)LEFT OUTER JOIN CODE_DEPT d ON e.unit=d.id)"
		+ "LEFT OUTER JOIN CODE_UNIT u ON e.unit_module=u.id WHERE e.category!='2' ORDER BY e.category, s.sno"));
		p.print();		
		return null;
	}

}
