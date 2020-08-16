package com.plxcc.algorithm.hash;

import java.util.Scanner;

/**
 * @PackgeName: com.plxcc.algorithm.hash
 * @ClassName: HashDemon
 * @Author: plxc
 * Date: 2020/8/16 7:22
 * project name: 算法练习区
 * @Version:
 * @Description: 哈希表的应用()
 */
public class HashDemon {

    public static void main(String[] args) {
        //创建一个hash表
        HashTab hashTab = new HashTab(7);
        //简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加成员");
            System.out.println("exit:退出");
            System.out.println("list：显示雇员");
            key=scanner.next();
            switch (key) {
                case "add":
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    break;
                default:
                    break;
            }
            if(key.equals("exit")){
                scanner.close();
                break;
            }
        }
    }


    /**
     * 创建HashTable，管理多条链表
     */
    static class HashTab {
        private EmpLinkList[] empLinkListsArry;
        //表示有多少条链表
        private int size;

        public HashTab(int size) {
            this.size = size;
            this.empLinkListsArry = new EmpLinkList[size];
            //TODO
            //要初始化每一条链表
           for(int i=0;i<empLinkListsArry.length;i++){
               empLinkListsArry[i]=new EmpLinkList();
           }
        }

        //添加雇员
        public void add(Emp emp) {
            //根据员工的id，得到该员工应该添加到哪条链表
            int empLisnkListNum = hasFun(emp.id);
            //讲emp添加到对应的链表中
            empLinkListsArry[empLisnkListNum].add(emp);
        }

        //遍历所有的链表,遍历hash表
        public void list() {
//            for (EmpLinkList i : empLinkListsArry) {
//                i.list();
//            }
            for(int i=0;i<empLinkListsArry.length;i++){
                empLinkListsArry[i].list(i);
            }
        }

        //编写一个散列函数
        public int hasFun(int id) {
            return id % this.size;

        }

    }

    /**
     * 表示一个成员
     */
    static class Emp {
        public int id;
        public String name;
        public Emp next;//默认空

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * 创建EmpLinkList，表示链表
     */
    static class EmpLinkList {
        //头指针指向第一个雇员,因此head是有效的，直接指向第一个雇员Emp
        private Emp head;//默认空
        //添加雇员到链表
        public void add(Emp emp) {
            //若果是添加第一个雇员
            if (head == null) {
                head = emp;
                return;
            }
            //如果不是第一个雇员，则使用辅助指针，帮助定位到最后
            Emp current = head;
            while (true) {
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = emp;
        }

        //遍历链表的雇员信息
        public void list(int no) {
            if (head == null) {//说明链表为空
                System.out.println("当前"+no+"链表为空");
                return;
            }
            System.out.println("当前"+no+"链表信息为");
            Emp curEmp = head;
            while (true) {
                System.out.printf("=>id=%s name=%s\t", curEmp.id, curEmp.name);
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            System.out.println();
        }
    }
}
