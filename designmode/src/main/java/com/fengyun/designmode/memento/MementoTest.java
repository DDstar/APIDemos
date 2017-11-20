package fengyun.designmode.memento;

public class MementoTest {
	
	public static void main(String[] args) {
		Original origi = new Original("egg");
		Storage storage = new Storage(origi.createMemento());
		System.out.println("��ʼ��״̬Ϊ��" + origi.getValue());
		origi.setValue("niu");
		System.out.println("�޸ĺ��״̬Ϊ��" + origi.getValue());
		
		origi.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ��" + origi.getValue());
		
		
				
	}
}
