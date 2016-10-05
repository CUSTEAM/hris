package action.print;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import action.BaseAction;

public class StayTimePrint extends BaseAction{
	HttpServletResponse response;
	List<Map>none;
	List<Map>edit;
	List<Map>empls;
	List<Map>enough;
	List<Map>alltime;
	String kind;
	Map info;
	public StayTimePrint(HttpServletResponse response,String kind, List<Map>none, List<Map>edit, List<Map>empls, List<Map>enough, List<Map>alltime, Map info){
		this.response=response;
		this.none=none;
		this.edit=edit;
		this.empls=empls;
		this.enough=enough;
		this.alltime=alltime;
		this.info=info;
		this.kind=kind;
	}
	
	public void print() throws IOException{		
		Date date=new Date();
		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition","attachment;filename="+date.getTime()+".xls");			
		
		PrintWriter out=response.getWriter();
		
		out.println ("<?xml version='1.0'?>");
		out.println ("<?mso-application progid='Excel.Sheet'?>");
		out.println ("<Workbook xmlns='urn:schemas-microsoft-com:office:spreadsheet'");
		out.println (" xmlns:o='urn:schemas-microsoft-com:office:office'");
		out.println (" xmlns:x='urn:schemas-microsoft-com:office:excel'");
		out.println (" xmlns:ss='urn:schemas-microsoft-com:office:spreadsheet'");
		out.println (" xmlns:html='http://www.w3.org/TR/REC-html40'>");
		out.println (" <DocumentProperties xmlns='urn:schemas-microsoft-com:office:office'>");
		out.println ("  <Author>shawn</Author>");
		out.println ("  <LastAuthor>shawn</LastAuthor>");
		out.println ("  <Created>2014-12-31T04:42:13Z</Created>");
		out.println ("  <LastSaved>2014-12-31T06:23:10Z</LastSaved>");
		out.println ("  <Version>15.00</Version>");
		out.println (" </DocumentProperties>");
		out.println (" <OfficeDocumentSettings xmlns='urn:schemas-microsoft-com:office:office'>");
		out.println ("  <AllowPNG/>");
		out.println (" </OfficeDocumentSettings>");
		out.println (" <ExcelWorkbook xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("  <WindowHeight>11880</WindowHeight>");
		out.println ("  <WindowWidth>28800</WindowWidth>");
		out.println ("  <WindowTopX>0</WindowTopX>");
		out.println ("  <WindowTopY>0</WindowTopY>");
		out.println ("  <ProtectStructure>False</ProtectStructure>");
		out.println ("  <ProtectWindows>False</ProtectWindows>");
		out.println (" </ExcelWorkbook>");
		out.println (" <Styles>");
		out.println ("  <Style ss:ID='Default' ss:Name='Normal'>");
		out.println ("   <Alignment ss:Vertical='Center'/>");
		out.println ("   <Borders/>");
		out.println ("   <Font ss:FontName='新細明體' x:CharSet='136' x:Family='Roman' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <Interior/>");
		out.println ("   <NumberFormat/>");
		out.println ("   <Protection/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s62' ss:Name='超連結'>");
		out.println ("   <Font ss:FontName='新細明體' x:CharSet='136' x:Family='Roman' ss:Size='12'");
		out.println ("    ss:Color='#0066CC' ss:Underline='Single'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s63'>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s64'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s66' ss:Parent='s62'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("   </Borders>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s67'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat/>");
		out.println ("  </Style>");	
		
		out.println ("  <Style ss:ID='s68'>");
		out.println ("   <Borders/>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s69'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");		
		
		out.println ("  <Style ss:ID='s77'>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s79'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s80'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		
		out.println (" </Styles>");
		out.println (" <Worksheet ss:Name='未填寫'>");
		out.println ("  <Names>");
		out.println ("   <NamedRange ss:Name='_FilterDatabase' ss:RefersTo='=未填寫!R1C1:R2C5' ss:Hidden='1'/>");
		out.println ("  </Names>");
		out.println ("  <Table ss:ExpandedColumnCount='5' ss:ExpandedRowCount='"+(none.size()+1)+"' x:FullColumns='1'");
		out.println ("   x:FullRows='1' ss:StyleID='s63' ss:DefaultColumnWidth='54'");
		out.println ("   ss:DefaultRowHeight='15.75'>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='79.5'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='111.75'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='120'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='79.5'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='199.5'/>");
		out.println ("   <Row ss:AutoFitHeight='0'>");
		out.println ("    <Cell><Data ss:Type='String'>姓名</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>職稱</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>主聘系所</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>行動電話</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>電子郵件</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("   </Row>");	
		
		for(int i=0; i<none.size(); i++){
			out.println ("   <Row ss:AutoFitHeight='0' ss:Height='16.5'>");
			out.println ("    <Cell><Data ss:Type='String'>"+none.get(i).get("cname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+none.get(i).get("sname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+none.get(i).get("dname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+none.get(i).get("CellPhone")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell ss:StyleID='s66' ss:HRef='mailto:"+none.get(i).get("Email")+"'><Data ss:Type='String'>"+none.get(i).get("Email")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("   </Row>");
		}		
		out.println ("  </Table>");
		out.println ("  <WorksheetOptions xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("   <PageSetup>");
		out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,標準&quot;&amp;18 "+info.get("school_year")+"學年度第"+info.get("school_term")+"學期專任教師未填寫留校時間清單'/>");
		out.println ("    <Footer x:Margin='0.3' x:Data='&amp;R&amp;P/&amp;N'/>");
		out.println ("    <PageMargins x:Bottom='0.75' x:Left='0.25' x:Right='0.25' x:Top='0.75'/>");
		out.println ("   </PageSetup>");
		out.println ("   <Unsynced/>");
		out.println ("   <Print>");
		out.println ("    <ValidPrinterInfo/>");
		out.println ("    <PaperSizeIndex>9</PaperSizeIndex>");
		out.println ("    <HorizontalResolution>-1</HorizontalResolution>");
		out.println ("    <VerticalResolution>-1</VerticalResolution>");
		out.println ("   </Print>");
		out.println ("   <Selected/>");
		out.println ("   <Panes>");
		out.println ("    <Pane>");
		out.println ("     <Number>3</Number>");
		out.println ("     <ActiveRow>6</ActiveRow>");
		out.println ("     <ActiveCol>9</ActiveCol>");
		out.println ("    </Pane>");
		out.println ("   </Panes>");
		out.println ("   <ProtectObjects>False</ProtectObjects>");
		out.println ("   <ProtectScenarios>False</ProtectScenarios>");
		out.println ("  </WorksheetOptions>");
		out.println ("  <AutoFilter x:Range='R1C1:R2C5' xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("  </AutoFilter>");
		out.println (" </Worksheet>");
		
		
		
		
		out.println (" <Worksheet ss:Name='不足'>");
		out.println ("  <Table ss:ExpandedColumnCount='7' ss:ExpandedRowCount='"+enough.size()+1+"' x:FullColumns='1'");
		out.println ("   x:FullRows='1' ss:StyleID='s77' ss:DefaultColumnWidth='54'");
		out.println ("   ss:DefaultRowHeight='15.75'>");
		out.println ("   <Column ss:StyleID='s80' ss:AutoFitWidth='0'/>");
		out.println ("   <Column ss:StyleID='s80' ss:AutoFitWidth='0' ss:Width='96' ss:Span='1'/>");
		out.println ("   <Column ss:Index='4' ss:StyleID='s80' ss:AutoFitWidth='0' ss:Width='32.25'");
		out.println ("    ss:Span='1'/>");
		out.println ("   <Column ss:Index='6' ss:StyleID='s80' ss:AutoFitWidth='0' ss:Width='96'/>");
		out.println ("   <Column ss:StyleID='s80' ss:AutoFitWidth='0' ss:Width='183.75'/>");
		out.println ("   <Row ss:AutoFitHeight='0' ss:StyleID='s63'>");
		out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>姓名</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>職稱</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>主聘系所</Data></Cell>");
		if(kind.equals("1")){
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>應設</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>實設</Data></Cell>");
		}else{
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>班級數</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>時數</Data></Cell>");
		}
		
		
		out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>行動電話</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>電子郵件</Data></Cell>");
		out.println ("   </Row>");
		int t, s, r;
		for(int i=0; i<enough.size(); i++){	
			
			t=Integer.parseInt(enough.get(i).get("t").toString());
			s=Integer.parseInt(enough.get(i).get("s").toString());
			r=Integer.parseInt(enough.get(i).get("r").toString());
			if((s-t)<=r)continue;
			out.println ("   <Row>");
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>"+enough.get(i).get("cname")+"</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>"+enough.get(i).get("sname")+"</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>"+enough.get(i).get("dname")+"</Data></Cell>");			
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>"+(s-t)+"</Data></Cell>");		
			out.println ("    <Cell ss:StyleID='s79'><Data ss:Type='String'>"+r+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+enough.get(i).get("CellPhone")+"</Data></Cell>");
			//out.println ("    <Cell><Data ss:Type='String'>"+enough.get(i).get("E")+"</Data></Cell>");			
			out.println ("    <Cell ss:StyleID='s66' ss:HRef='mailto:"+enough.get(i).get("Email")+"'><Data ss:Type='String'>"+enough.get(i).get("Email")+"</Data></Cell>");
			out.println ("   </Row>");
		}
		
		out.println ("  </Table>");
		out.println ("  <WorksheetOptions xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("   <PageSetup>");
		out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,標準&quot;&amp;18 "+info.get("school_year")+"學年度第"+info.get("school_term")+"學期專任教師不足留校時間清單'/>");
		out.println ("    <Footer x:Margin='0.3'/>");
		out.println ("    <PageMargins x:Bottom='0.75' x:Left='0.25' x:Right='0.25' x:Top='0.75'/>");
		out.println ("   </PageSetup>");
		out.println ("   <Print>");
		out.println ("    <ValidPrinterInfo/>");
		out.println ("    <PaperSizeIndex>9</PaperSizeIndex>");
		out.println ("    <HorizontalResolution>-1</HorizontalResolution>");
		out.println ("    <VerticalResolution>-1</VerticalResolution>");
		out.println ("   </Print>");
		out.println ("   <Selected/>");
		out.println ("   <Panes>");
		out.println ("    <Pane>");
		out.println ("     <Number>3</Number>");
		out.println ("     <ActiveRow>5</ActiveRow>");
		out.println ("     <ActiveCol>2</ActiveCol>");
		out.println ("    </Pane>");
		out.println ("   </Panes>");
		out.println ("   <ProtectObjects>False</ProtectObjects>");
		out.println ("   <ProtectScenarios>False</ProtectScenarios>");
		out.println ("  </WorksheetOptions>");
		out.println (" </Worksheet>");
		
		
		
		out.println (" <Worksheet ss:Name='修改記錄'>");
		out.println ("  <Names>");
		out.println ("   <NamedRange ss:Name='_FilterDatabase' ss:RefersTo='=修改記錄!R1C1:R2C5' ss:Hidden='1'/>");
		out.println ("  </Names>");
		out.println ("  <Table ss:ExpandedColumnCount='5' ss:ExpandedRowCount='"+edit.size()+1+"' x:FullColumns='1'");
		out.println ("   x:FullRows='1' ss:StyleID='s63' ss:DefaultColumnWidth='54'");
		out.println ("   ss:DefaultRowHeight='15.75'>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='79.5'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='111.75'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='120'/>");
		out.println ("   <Column ss:StyleID='s67' ss:AutoFitWidth='0' ss:Width='79.5'/>");
		out.println ("   <Column ss:StyleID='s64' ss:AutoFitWidth='0' ss:Width='199.5'/>");
		out.println ("   <Row ss:AutoFitHeight='0'>");
		out.println ("    <Cell><Data ss:Type='String'>姓名</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>職稱</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>主聘系所</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>修改次數</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("    <Cell><Data ss:Type='String'>最後修改日期</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
		out.println ("   </Row>");
		
		for(int i=0; i<edit.size(); i++){
			out.println ("   <Row ss:AutoFitHeight='0' ss:Height='16.5'>");
			out.println ("    <Cell><Data ss:Type='String'>"+edit.get(i).get("cname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+edit.get(i).get("sname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+edit.get(i).get("dname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='Number'>"+edit.get(i).get("cnt")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			if(edit.get(i).get("edate")!=null){
				out.println ("    <Cell><Data ss:Type='String'>"+edit.get(i).get("edate")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			}else{
				out.println ("    <Cell><Data ss:Type='String'></Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			}
			
			out.println ("   </Row>");
		}
		
		out.println ("  </Table>");
		out.println ("  <WorksheetOptions xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("   <PageSetup>");
		out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,標準&quot;&amp;18 "+info.get("school_year")+"學年度第"+info.get("school_term")+"學期專任教師變更留校時間次數清單'/>");
		out.println ("    <Footer x:Margin='0.3' x:Data='&amp;R&amp;P/&amp;N'/>");
		out.println ("    <PageMargins x:Bottom='0.75' x:Left='0.25' x:Right='0.25' x:Top='0.75'/>");
		out.println ("   </PageSetup>");
		out.println ("   <Unsynced/>");
		out.println ("   <FilterOn/>");
		out.println ("   <Panes>");
		out.println ("    <Pane>");
		out.println ("     <Number>3</Number>");
		out.println ("     <ActiveRow>7</ActiveRow>");
		out.println ("     <ActiveCol>10</ActiveCol>");
		out.println ("    </Pane>");
		out.println ("   </Panes>");
		out.println ("   <ProtectObjects>False</ProtectObjects>");
		out.println ("   <ProtectScenarios>False</ProtectScenarios>");
		out.println ("  </WorksheetOptions>");
		out.println ("  <AutoFilter x:Range='R1C1:R2C5' xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("   <AutoFilterColumn x:Index='4' x:Type='Custom'>");
		out.println ("    <AutoFilterCondition x:Operator='GreaterThan' x:Value='3'/>");
		out.println ("   </AutoFilterColumn>");
		out.println ("  </AutoFilter>");
		out.println (" </Worksheet>");		
		
		String tmp, tmp1;
		int tmp2[], tmp3, cnt;
		for(int i=1; i<=7; i++){
			
			out.println (" <Worksheet ss:Name='"+bl.getWeekOfDay4Zh(i, "星期")+"'>");
			out.println ("  <Names>");
			out.println ("   <NamedRange ss:Name='_FilterDatabase' ss:RefersTo='="+bl.getWeekOfDay4Zh(i, "星期")+"!R1C1:R2C7' ss:Hidden='1'/>");
			out.println ("  </Names>");
			out.println ("  <Table ss:ExpandedColumnCount='7' ss:ExpandedRowCount='"+empls.size()+1+"' x:FullColumns='1'");
			out.println ("   x:FullRows='1' ss:StyleID='s68' ss:DefaultColumnWidth='54' ss:DefaultRowHeight='15.75'>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='90'/>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='50'/>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='60'/>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='90'/>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='85'/>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='100'/>");
			out.println ("   <Column ss:StyleID='s69' ss:AutoFitWidth='0' ss:Width='115'/>");
			
			out.println ("   <Row ss:AutoFitHeight='0'>");
			out.println ("    <Cell><Data ss:Type='String'>主聘系所</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>姓名</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>分機</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>行動電話</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>辦公室位置</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>留校節次</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>其他留校日</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
			out.println ("   </Row>");			
			
			for(int j=0; j<empls.size(); j++){				
				tmp="";tmp1="";
				for(int k=0; k<alltime.size(); k++){
					//if(alltime.get(k)==null)continue;					
					if(alltime.get(k).get("idno").equals(empls.get(j).get("idno"))&& Integer.parseInt(alltime.get(k).get("week").toString())==i){
						tmp+=alltime.get(k).get("period")+",";
						//alltime.remove(k);
					}
				}				
				if(tmp.equals(""))continue;
				tmp2=new int[8];
				for(int k=0; k<alltime.size(); k++){					
					if(alltime.get(k).get("idno").equals(empls.get(j).get("idno"))){	
						tmp3=Integer.parseInt(alltime.get(k).get("week").toString());
						tmp2[tmp3]=tmp3;
					}
				}
				
				out.println ("   <Row>");
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("dname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("cname")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("contact")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("CellPhone")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("place")+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");				
				out.println ("    <Cell><Data ss:Type='String'>"+tmp+"</Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");				
				out.println ("    <Cell><Data ss:Type='String'>");
				
				for(int k=0; k<tmp2.length; k++){
					if(tmp2[k]==0)continue;
					out.println (bl.getWeekOfDay4Zh(tmp2[k], ""));
				}
				out.println ("    </Data><NamedCell ss:Name='_FilterDatabase'/></Cell>");
				out.println ("   </Row>");				
			}
			
			out.println ("  </Table>");
			out.println ("  <WorksheetOptions xmlns='urn:schemas-microsoft-com:office:excel'>");
			out.println ("   <PageSetup>");
			if(kind.equals("1")){
				out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,粗體&quot;"+info.get("school_year")+"學年度第"+info.get("school_term")+"學期專任教師課後輔導節次表&#10;"+bl.getWeekOfDay4Zh(i, "星期")+"'/>");
			}else{
				out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,粗體&quot;"+info.get("school_year")+"學年度第"+info.get("school_term")+"學期專任教師生活輔導節次表&#10;"+bl.getWeekOfDay4Zh(i, "星期")+"'/>");
			}
			out.println ("    <Footer x:Margin='0.3'/>");
			out.println ("    <PageMargins x:Bottom='0.75' x:Left='0.25' x:Right='0.25' x:Top='0.75'/>");
			out.println ("   </PageSetup>");
			out.println ("   <Unsynced/>");
			out.println ("   <Print>");
			out.println ("    <ValidPrinterInfo/>");
			out.println ("    <PaperSizeIndex>9</PaperSizeIndex>");
			out.println ("    <HorizontalResolution>-1</HorizontalResolution>");
			out.println ("    <VerticalResolution>-1</VerticalResolution>");
			out.println ("   </Print>");
			out.println ("   <Selected/>");
			out.println ("   <FreezePanes/>");
			out.println ("   <FrozenNoSplit/>");
			out.println ("   <SplitHorizontal>1</SplitHorizontal>");
			out.println ("   <TopRowBottomPane>1</TopRowBottomPane>");
			out.println ("   <ActivePane>2</ActivePane>");
			out.println ("   <Panes>");
			out.println ("    <Pane>");
			out.println ("     <Number>3</Number>");
			out.println ("    </Pane>");
			out.println ("    <Pane>");
			out.println ("     <Number>2</Number>");
			out.println ("     <ActiveRow>22</ActiveRow>");
			out.println ("     <ActiveCol>5</ActiveCol>");
			out.println ("    </Pane>");
			out.println ("   </Panes>");
			out.println ("   <ProtectObjects>False</ProtectObjects>");
			out.println ("   <ProtectScenarios>False</ProtectScenarios>");
			out.println ("  </WorksheetOptions>");
			out.println ("  <AutoFilter x:Range='R1C1:R2C7' xmlns='urn:schemas-microsoft-com:office:excel'>");
			out.println ("  </AutoFilter>");
			out.println (" </Worksheet>");
			
		}		
		out.println ("</Workbook>");		
		out.close();
	}
}