package bean;

public class Page {
    private int currentpage;//当前页数
    private int totalpage;//总页数
    private int totalcount; //总数据数
    private int everycount;//每页数据项
    private int beginindex;//每页起始点
    private boolean isNextHas;//是否有下一页
    private boolean isPerHas;//是否有上一页
    
    public Page() {}

	public Page(int currentpage, int totalpage, int totalcount, int everycount, int beginindex, boolean isNextHas,
			boolean isPerHas) {
		super();
		this.currentpage = currentpage;
		this.totalpage = totalpage;
		this.totalcount = totalcount;
		this.everycount = everycount;
		this.beginindex = beginindex;
		this.isNextHas = isNextHas;
		this.isPerHas = isPerHas;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getEverycount() {
		return everycount;
	}

	public void setEverycount(int everycount) {
		this.everycount = everycount;
	}

	public int getBeginindex() {
		return beginindex;
	}

	public void setBeginindex(int beginindex) {
		this.beginindex = beginindex;
	}

	public boolean getIsNextHas() {
		return isNextHas;
	}

	public void setIsNextHas(boolean isNextHas) {
		this.isNextHas = isNextHas;
	}

	public boolean getIsPerHas() {
		return isPerHas;
	}

	public void setIsPerHas(boolean isPerHas) {
		this.isPerHas = isPerHas;
	}
    
    
}
