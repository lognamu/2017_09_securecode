package util;

public class Paging {
	public static String getPaging(String pageUrl, 
									int nowPage, 
									int rowCount, 
									int blockList, 
									int blockPage,
									String searchParam){
		StringBuffer sb = new StringBuffer();
		
		//전체 페이지수
		int totalPage;
		//시작 페이지
		int startPage;
		//마지막 페이지
		int endPage;
		
		boolean isPrevPage = false;
		boolean isNextPage = false;
		
		
		if(rowCount % blockList == 0){
			totalPage = (int)(rowCount/blockList);
		}else{
			totalPage = (int)(rowCount/blockList) + 1;
		}
		//▶를 누르게 되면 한페이지씩 이동하기 때문에 현재페이지가 마지막페이지보다 커질 수도 있음
		if(nowPage > totalPage){
			nowPage = totalPage;
		}
		
		startPage = (int)((nowPage-1)/blockPage)*blockPage + 1;
		endPage = startPage + blockPage - 1;
		
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		if(totalPage >= startPage + blockPage){
			isNextPage = true;
		}
		
		if(nowPage - blockPage > 0){
			isPrevPage = true;
		}
		
		//이전페이지
		if(isPrevPage){
			sb.append("<a href='"+pageUrl+"?page=");
			sb.append(nowPage-blockPage);
			sb.append("'>◀</a>");
		}else{
			sb.append("◁");
		}
		
		//페이지목록
		sb.append("");
		for(int i=startPage; i <= endPage; i++){
			if(i == nowPage){
				sb.append("&nbsp;<span class='selected'>");
				sb.append(i);
				sb.append("</span>");
			}else{
				sb.append("&nbsp;<a href='"+pageUrl+"?page=");
				sb.append(i);
				sb.append("&"+searchParam+"'>");
				sb.append(i);
				sb.append("</a>");
			}
		}
		sb.append("&nbsp;");
		
		//다음페이지
		if(isNextPage){
			sb.append("<a href='"+pageUrl+"?page=");
			if(nowPage+blockPage > totalPage){
				nowPage = totalPage;
			}else{
				nowPage += blockPage;
			}
			sb.append(nowPage);
			sb.append("'>▶</a>");
		}else{
			sb.append("▷");
		}
		
		return sb.toString();
		
		
	}
}
