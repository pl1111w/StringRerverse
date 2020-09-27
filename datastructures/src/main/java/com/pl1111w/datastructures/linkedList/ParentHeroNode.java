package com.pl1111w.datastructures.linkedList;

import lombok.Data;

/**
 * @title: pl1111w
 * @description: 链表头节点
 * @author: Kris
 * @date 2020/9/26 11:16
 */
@Data
public class ParentHeroNode {

    private HeroNode headNode = new HeroNode(0, "", "");

    //无序添加
    public void addNode(HeroNode node) {
        HeroNode temp = this.headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);

    }

    //有序添加
    public void addNodeByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = headNode;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.getNo());
        } else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    public void updateNode(HeroNode heroNode) {
        HeroNode temp = this.headNode;
        boolean update = false;
        while (true) {
            if (temp.getNext() == null) {
                return;
            } else {
                if (temp.getNext().getNo() == heroNode.getNo()) {
                    temp.setNext(heroNode);
                    update = true;
                    break;
                }
                temp = temp.getNext();
            }
        }
        if (update) {
            System.out.println("没找到更新的节点:" + heroNode);
        } else {
            System.out.println("更新HeroNode: " + headNode.toString());
        }
    }

    public void deleteNode(int no) {
        HeroNode temp = this.headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }else if(temp.getNext().getNo()==no){
                temp.setNext(temp.getNext().getNext());
                break;
            }else {
                if (temp.getNext().getNext() == null) {
                    System.out.println("没找到删除节点：" + no);
                    break;
                } else if (temp.getNext().getNext().getNo() == no) {
                    HeroNode beforeOfDelete = temp.getNext();
                    HeroNode afterOfDelete =temp.getNext().getNext().getNext();
                    beforeOfDelete.setNext(afterOfDelete);
                    break;
                }
            }
            temp = temp.getNext();
        }
    }

}
