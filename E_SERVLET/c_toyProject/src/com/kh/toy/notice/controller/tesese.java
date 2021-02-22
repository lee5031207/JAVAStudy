package com.kh.toy.notice.controller;

public class tesese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=64; i<=73; i++) {
//			System.out.println("INSERT INTO SH_REPORT(report_idx, MB_ID, GROUP_IDX, REPORT_CONTENT, REPORT_TITLE) VALUES (SC_REPORT_IDX.nextval, 'test1', 1100, '도망가', '신고내역"+i+"');");
			System.out.println("INSERT INTO SH_REPORT(report_idx, MB_ID, GROUP_IDX, REPORT_CONTENT, REPORT_TITLE, REPORT_CLEAR) VALUES (SC_REPORT_IDX.nextval, 'test1', 1100, '도망가', '신고내역"+i+"', 1);");
		}
	}

}
