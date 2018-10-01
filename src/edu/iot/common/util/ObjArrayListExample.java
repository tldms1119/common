package edu.iot.common.util;

import edu.iot.common.util.Member;

public class ObjArrayListExample {

	public static void main(String[] args) {
		
		ObjList<Integer> list = new ObjArrayList<>();
		
		list.add(11);
		list.add(23);
		list.add(13);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");;
		}
		
		System.out.println();
		list.add(2, 19);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");;
		}
		
		System.out.println();
		list.remove(1);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");;
		}
		
		System.out.println();
		list.set(2, 17);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");;
		}
		
		System.out.println();
		list.swap(0, 2);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");;
		}
		System.out.println();
		
		
		// Builder 패턴(method chaining)
		ObjList<Member> memberList = new ObjArrayList<>();
		Member member = new Member.Builder()
							.setName("홍길동")
							.setUserId("hong")
							.setPassword("1234")
							.build();
		memberList.add(member);
		
		member = new Member.Builder()
							.setName("고길동")
							.setUserId("go")
							.build();
		memberList.add(member);
		
		member = new Member.Builder()
							.setName("최시은")
							.setAddress("suwon")
							.build();
		memberList.add(member);
		
		System.out.println(member.getMember());
		
		for(int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
		
	}
	

}
