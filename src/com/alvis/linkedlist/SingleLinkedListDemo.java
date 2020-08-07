package com.alvis.linkedlist;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode heroNode = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode heroNode1 = new HeroNode(2, "¬����", "������");
		HeroNode heroNode2 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode heroNode3 = new HeroNode(4, "�ֳ�", "����ͷ");

		// singleLinkedList.add(heroNode);
		// singleLinkedList.add(heroNode2);
		// singleLinkedList.add(heroNode1);
		// singleLinkedList.add(heroNode3);

		// singleLinkedList.list();

		singleLinkedList.addByNo(heroNode);
		singleLinkedList.addByNo(heroNode2);
		singleLinkedList.addByNo(heroNode1);
		singleLinkedList.addByNo(heroNode3);

		// HeroNode updateHeroNode = new HeroNode(5, "¬", "С¬");
		// singleLinkedList.update(updateHeroNode);
		// singleLinkedList.list();

		 singleLinkedList.delete(1);
		 singleLinkedList.delete(2);
		 singleLinkedList.delete(4);
		 singleLinkedList.delete(3);
		singleLinkedList.list();
	}
}

// ����SingleLinkedList �������ǵ�Ӣ��
class SingleLinkedList {
	// �ȳ�ʼ��ͷ�ڵ㣬һ�㲻�ܶ�,����ž�������
	private HeroNode head = new HeroNode(0, "", "");

	// ��ӽڵ㵽��������
	public void add(HeroNode heroNode) {
		// �������Ǳ��˳��ʱ��
		// 1���ҵ���ǰ��������ڵ�
		// 2�������ڵ��next ָ���µĽڵ�
		HeroNode temp = head;

		while (true) {
			// �ҵ��������
			if (temp.next == null) {
				break;
			}

			// û���ҵ���󣬽�temp�����
			temp = temp.next;
		}

		// ���˳�ѭ��ʱ��temp��ָ����������
		temp.next = heroNode;
	}

	// ����
	public void addByNo(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}

			if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}

			temp = temp.next;
		}

		if (flag) {
			
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// ��
	public void update(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		if (flag) {
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		} else {
			System.out.println("δ�ҵ�");
			add(heroNode);
		}

	}

	// ɾ
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		 if (flag) {
		 temp.next = temp.next.next;
		 } else {
		 System.out.println("û�и����" + no);
		 }

	}

	// ��ʾ����
	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��~~~~");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

// ����HeroNode , ÿ��HeroNode �������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next; // ָ����һ���ڵ�

	public HeroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName="
				+ nickName + "]";
	}

}