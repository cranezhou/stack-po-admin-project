/**
 * 
 */
package com.rillsoft.stackpoadmin.utils;

/**
 * @author crane
 *
 */
public class PageInfo {

	public static final int INITIAL_PAGE_SIZE = 5;
	
	private int m_nPageIndex = 0;
	
	private int m_nPageSize = 3;
	
	private int m_nPageTotal = 0;
	
	/**
	 * 
	 */
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int nPageIndex, int nPageSize) {
		// TODO Auto-generated constructor stub
	
		m_nPageIndex = nPageIndex;
		
		m_nPageSize = nPageSize;
	}

	public int GetPageSize() {
		return m_nPageSize; 
	}
	
	public int GetPageIndex() {
		return m_nPageIndex; 
	}
	
	public int SetPageTotal(int nPageTotal) {
		return m_nPageTotal = nPageTotal; 
	}
	
	public int GetPageTotal() {
		return m_nPageTotal; 
	}
}
