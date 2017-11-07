package util;

import bean.Page;

public class PageUtil {
    //辅助生成page
	public static Page getPage(int currentpage,int totalcount,int everycount) {
		
		int totalpage = getTotalpage(totalcount,everycount);
		int beginindex = getBeginIndex(currentpage,everycount);
		int everyCount = getEverycount(beginindex,everycount,totalcount);
		boolean isNextHas = getIsNextHas(currentpage,totalpage);
		boolean isPerHas = getIsPerHas(currentpage);
		
		return new Page(currentpage,totalpage,totalcount
				,everyCount,beginindex,isNextHas,isPerHas);
	}
	
	
	public  static int getTotalpage(int totalcount,int everycount) {
		
		if (totalcount % everycount == 0) {
			return totalcount / everycount;
		}
		else 
			return (totalcount / everycount)+1;
		
		
		
		
	}
	
	public static int getBeginIndex(int currentpage,int everycount) {
		return (currentpage-1)*everycount;
	}
	
	public static int getEverycount(int beginindex,int everycount,int totalcount) {
		if ((beginindex + everycount )> totalcount ) {
			return totalcount - beginindex;
		}
		else 
			return everycount;
	}
	
	public static boolean getIsNextHas(int currentpage,int totalpage) {
		if (currentpage < totalpage) {
			return true; 
		}else 
			return false;
	}
	
	public static boolean getIsPerHas(int currentpage) {
		if (currentpage > 1) {
			return true;
		}else
			return false;
	}
	
}
