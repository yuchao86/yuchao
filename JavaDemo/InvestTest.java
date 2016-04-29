

public class InvestTest extends Thread{
	
	public InvestTest(String userCode){
		super(userCode);
	}
	
	public void run(){
		for(int i=0;i<1;i++){
			String userCode = this.getName();
			final String url = "http://101.201.152.200/openapi/invest/setInvest?sessionId=&biddCode=b1f8a01d-97e9-456a-a073-f3b6cded7112&amount=100&signType=MD5&sign=&userCode="+userCode;
			String resJSON = HttpUtil.sendGet(url, "UTF-8");
			System.out.println(url);
			System.out.println(resJSON);
		}
	}
	
	

	public static void main(String[] args){
//		String url = "http://101.201.152.200/openapi/invest/setInvest";
		String[] userCodes = new String[]{"2e919529-9fb5-11e5-8645-008cfae40e8c","1eb868b7-40c9-11e5-9ecc-1051721c3a3e","75327f17-0827-11e5-b70f-1051721c3a3e","a96aa5f2-1c27-11e5-9ecc-1051721c3a3e"};
		String user1 = userCodes[0];
		Thread t1 = new InvestTest(user1);
		t1.start();
		String user2 = userCodes[1];
		Thread t2 = new InvestTest(user2);
		t2.start();
		String user3 = userCodes[2];
		Thread t3 = new InvestTest(user3);
		t3.start();
		String user4 = userCodes[3];
		Thread t4 = new InvestTest(user4);
		t4.start();

	}

}