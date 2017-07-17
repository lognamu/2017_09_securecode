package vo;

import java.util.List;

public class CartVo {
	private int idx, p_idx, u_idx, count;
	private ProductVo pvo;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public ProductVo getPvo() {
		return pvo;
	}
	public void setPvo(ProductVo pvo) {
		this.pvo = pvo;
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
