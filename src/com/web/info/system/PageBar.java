package com.web.info.system;

public class PageBar {

	private int rowsOfPage = 10;
	private int currOfPage = 1;
	private int totalOfPage = 0;
	private int totalRows = 0;

	private String fistLabel = "首页";
	private String preLabel = "上页";
	private String nextLabel = "下页";
	private String lastLabel = "末页";

	private String pageSpace = "&nbsp;";
	private String pagePrefix = "";

	// private String pageNum = "pageNum";
	// private String pageSize = "pageSize";

	private void setTotalPage(int total) {
		this.totalRows = total;
		int rest = total % rowsOfPage, ii = total / rowsOfPage;
		if (total == 0) {
			totalOfPage = 0;
		} else if (rest == 0) {
			totalOfPage = ii;
		} else if (rest > 0) {
			totalOfPage = ii + 1;
		}
	}

	private String getPageSum() {
		StringBuffer select = new StringBuffer("总<b>" + totalRows + "</b>条 每页");
		select.append("<select id='pageSize' name='pageSize' onchange='pageGoSelect()'>");
		if (rowsOfPage == 10) {
			select.append("<option value='10' selected='selected'>10</option>").append("<option value='20'>20</option>").append("<option value='30'>30</option>").append("<option value='50'>50</option>");
		} else if (rowsOfPage == 20) {
			select.append("<option value='10'>10</option>").append("<option value='20' selected='selected'>20</option>").append("<option value='30'>30</option>").append("<option value='50'>50</option>");
		} else if (rowsOfPage == 30) {
			select.append("<option value='10'>10</option>").append("<option value='20'>20</option>").append("<option value='30' selected='selected'>30</option>").append("<option value='50'>50</option>");
		} else if (rowsOfPage == 50) {
			select.append("<option value='10'>10</option>").append("<option value='20'>20</option>").append("<option value='30'>30</option>").append("<option value='50' selected='selected'>50</option>");
		}
		select.append("</select>");
		select.append("条 分页<b>" + currOfPage + "</b>/<b>").append(totalOfPage).append("</b>" + pageSpace + pageSpace);
		return select.toString();
	}

	private String getPageGroup() {
		StringBuffer jump = new StringBuffer();
		int max = 0;
		if (currOfPage > 1 && currOfPage <= totalOfPage) {
			jump.append("[<a href='javascript:pageGoHref(\"1\");'>" + fistLabel + "</a>]" + pageSpace + "[<a href='javascript:pageGoHref(\"" + (currOfPage - 1) + "\");'>" + preLabel + "</a>]" + pageSpace);
		} else if (currOfPage == 1 || currOfPage == 0) {
			jump.append(fistLabel + pageSpace + preLabel + pageSpace);
		}
		if (currOfPage < 5) {
			max = Math.min(totalOfPage, 10);
			for (int i = 1; i <= max; i++) {
				if (i == currOfPage) {
					jump.append("[" + i + "]" + pageSpace);
				} else {
					jump.append("[<a href='javascript:pageGoHref(\"" + i + "\");'>" + i + "</a>]" + pageSpace);
				}
			}
		} else if (currOfPage >= 5 && totalOfPage - currOfPage >= 5) {
			max = Math.min(totalOfPage, currOfPage + 5);
			for (int i = currOfPage - 4; i <= max; i++) {
				if (i == currOfPage) {
					jump.append("[" + i + "]" + pageSpace);
				} else {
					jump.append("[<a href='javascript:pageGoHref(\"" + i + "\");'>" + i + "</a>]" + pageSpace);
				}
			}
		} else if (totalOfPage - currOfPage < 5) {
			max = totalOfPage;
			int start = Math.max(totalOfPage - 9, 1);
			for (int i = start; i <= max; i++) {
				if (i == currOfPage) {
					jump.append("[" + i + "]" + pageSpace);
				} else {
					jump.append("[<a href='javascript:pageGoHref(\"" + i + "\");'>" + i + "</a>]" + pageSpace);
				}
			}
		}
		if (currOfPage < totalOfPage && currOfPage >= 1) {
			jump.append("[<a href='javascript:pageGoHref(\"" + (currOfPage + 1) + "\");'>" + nextLabel + "</a>]" + pageSpace + "[<a href='javascript:pageGoHref(\"" + totalOfPage + "\");'>" + lastLabel + "</a>]");
		} else if (currOfPage == totalOfPage) {
			jump.append(nextLabel + pageSpace + lastLabel);
		}
		jump.append(pageSpace).append("<input id='pageNum' name='pageNum' type='text' size='2' maxlength='8' value='" + currOfPage + "' style='width:22px; height:14px; line-height:14px;' />").append("<input name='pageGo' type='submit' value='GO' style='width:20px;height:20px; font-size:10px;' onclick='javascript:return pageGoBtn();' />");
		return jump.toString();
	}

	private String getPageStat() {
		return "总<b>" + totalRows + "</b>条 每页<b>" + rowsOfPage + "</b>条 分页<b>" + currOfPage + "</b>/<b>" + totalOfPage + "</b>" + pageSpace + pageSpace;
	}

	private String getPageBar() {
		StringBuffer jump = new StringBuffer();
		int max = 0;
		if (currOfPage > 1 && currOfPage <= totalOfPage) {
			jump.append("[<a href='" + pagePrefix + 1 + "'>" + fistLabel + "</a>]" + pageSpace + "[<a href='" + pagePrefix + (currOfPage - 1) + "'>" + preLabel + "</a>]" + pageSpace);
		} else if (currOfPage == 1 || currOfPage == 0) {
			jump.append(fistLabel + pageSpace + preLabel + pageSpace);
		}
		if (currOfPage < 5) {
			max = Math.min(totalOfPage, 10);
			for (int i = 1; i <= max; i++) {
				if (i == currOfPage) {
					jump.append("[" + i + "]" + pageSpace);
				} else {
					jump.append("[<a href='" + pagePrefix + i + "'>" + i + "</a>]" + pageSpace);
				}
			}
		} else if (currOfPage >= 5 && totalOfPage - currOfPage >= 5) {
			max = Math.min(totalOfPage, currOfPage + 5);
			for (int i = currOfPage - 4; i <= max; i++) {
				if (i == currOfPage) {
					jump.append("[" + i + "]" + pageSpace);
				} else {
					jump.append("[<a href='" + pagePrefix + i + "'>" + i + "</a>]" + pageSpace);
				}
			}
		} else if (totalOfPage - currOfPage < 5) {
			max = totalOfPage;
			int start = Math.max(totalOfPage - 9, 1);
			for (int i = start; i <= max; i++) {
				if (i == currOfPage) {
					jump.append("[" + i + "]" + pageSpace);
				} else {
					jump.append("[<a href='" + pagePrefix + i + "'>" + i + "</a>]" + pageSpace);
				}
			}
		}
		if (currOfPage < totalOfPage && currOfPage >= 1) {
			jump.append("[<a href='" + pagePrefix + (currOfPage + 1) + "'>" + nextLabel + "</a>]" + pageSpace + "[<a href='" + pagePrefix + totalOfPage + "'>" + lastLabel + "</a>]");
		} else if (currOfPage == totalOfPage) {
			jump.append(nextLabel + pageSpace + lastLabel);
		}
		return jump.toString();
	}

	public String getPageTool(String pageNum, String pageSize, int total) {
		if (pageSize != null && pageSize.matches("(\\-|\\+)?[1-9]{1}\\d*")) {
			rowsOfPage = Integer.parseInt(pageSize);
		}
		setTotalPage(total);
		if (pageNum != null && pageNum.matches("(\\-|\\+)?[1-9]{1}\\d*")) {
			int num = Integer.parseInt(pageNum);
			if (num < 0) {
				num = 1;
			} else if (num > totalOfPage) {
				num = totalOfPage;
			}
			if (total == 0) {
				currOfPage = 0;
			} else {
				currOfPage = num;
			}
		} else if (total > 0) {
			currOfPage = 1;
		} else {
			currOfPage = 0;
		}
		return getPageSum() + getPageGroup();
	}

	public String getPageBar(String pageNum, String actionStr, int total) {
		setTotalPage(total);
		pagePrefix = actionStr;
		if (pageNum != null && pageNum.matches("(\\-|\\+)?[1-9]{1}\\d*")) {
			int num = Integer.parseInt(pageNum);
			if (num < 0) {
				num = 1;
			} else if (num > totalOfPage) {
				num = totalOfPage;
			}
			if (total == 0) {
				currOfPage = 0;
			} else {
				currOfPage = num;
			}
		} else if (total > 0) {
			currOfPage = 1;
		} else {
			currOfPage = 0;
		}
		return getPageStat() + getPageBar();
	}

	public String getCountSql(String sql) {
		return "select count(*) from (" + sql + ")t";
	}

	public String getPageListSql(String sql) {
		// if(currOfPage<1)
		// sql="select t.* from ("+sql+")t limit 0,"+rowsOfPage;
		// else
		// sql="select t.* from ("+sql+")t limit "+(currOfPage-1)*rowsOfPage+","+rowsOfPage;

		int temp = (currOfPage - 1) * rowsOfPage + 1;
		sql = "select * from (select t.*, rownum mynum from(" + sql + ")t where rownum <= " + (temp + rowsOfPage - 1) + ")  where mynum >= " + temp;
		// System.out.println("==sql==" + sql);
		return sql;
	}

	/**
	 * hpjqsd fenye
	 * 
	 * @param sql
	 * @param orderParam
	 * @return
	 */
	public String getPageListSql(String sql, String orderParam) {
		// if(currOfPage<1)
		// sql="select t.* from ("+sql+")t limit 0,"+rowsOfPage;
		// else
		// sql="select t.* from ("+sql+")t limit "+(currOfPage-1)*rowsOfPage+","+rowsOfPage;

		int temp = (currOfPage - 1) * rowsOfPage + 1;
		sql = "select * from (select t.*, rownum mynum from(" + sql + ") t order by " + orderParam + ") t where rownum <= " + (temp + rowsOfPage - 1) + "  and mynum >= " + temp;
		// System.out.println("==sql==" + sql);
		return sql;
	}

//	public static void main(String[] args) {
//		PageBar pu = new PageBar();
//		String actionStr = "abc.do?method=list&page=", pageNum = "4";
//		int totalRows = 1000;
//		String result = pu.getPageTool(pageNum, "10", totalRows);
//		System.out.println(result);
//		result = pu.getPageBar(pageNum, actionStr, totalRows);
//		System.out.println(result);
//	}
}
