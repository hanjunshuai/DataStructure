package com.alvis.linkedlist;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
		HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星");
		HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");

		// singleLinkedList.add(heroNode);
		// singleLinkedList.add(heroNode2);
		// singleLinkedList.add(heroNode1);
		// singleLinkedList.add(heroNode3);

		// singleLinkedList.list();

		singleLinkedList.addByNo(heroNode);
		singleLinkedList.addByNo(heroNode2);
		singleLinkedList.addByNo(heroNode1);
		singleLinkedList.addByNo(heroNode3);

		// HeroNode updateHeroNode = new HeroNode(5, "卢", "小卢");
		// singleLinkedList.update(updateHeroNode);
		// singleLinkedList.list();

		 singleLinkedList.delete(1);
		 singleLinkedList.delete(2);
		 singleLinkedList.delete(4);
		 singleLinkedList.delete(3);
		singleLinkedList.list();
	}
}

// 定义SingleLinkedList 管理我们得英雄
class SingleLinkedList {
	// 先初始化头节点，一般不能动,不存放具体数据
	private HeroNode head = new HeroNode(0, "", "");

	// 添加节点到单向链表
	public void add(HeroNode heroNode) {
		// 当不考虑编号顺序时：
		// 1、找到当前链表得最后节点
		// 2、将最后节点的next 指向新的节点
		HeroNode temp = head;

		while (true) {
			// 找到链表最后
			if (temp.next == null) {
				break;
			}

			// 没有找到最后，将temp向后移
			temp = temp.next;
		}

		// 当退出循环时，temp就指向链表的最后
		temp.next = heroNode;
	}

	// 插入
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

	// 改
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
			System.out.println("未找到");
			add(heroNode);
		}

	}

	// 删
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
		 System.out.println("没有该序号" + no);
		 }

	}

	// 显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空~~~~");
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

// 定义HeroNode , 每个HeroNode 对象就是一个节点
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next; // 指向下一个节点

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