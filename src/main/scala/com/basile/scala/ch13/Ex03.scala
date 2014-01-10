package com.basile.scala.ch13

/**
 * Created by basile.duplessis on 10/01/14.
 */
object Ex03 extends App {
  import scala.collection.mutable.LinkedList

  def rmZeroes(l: LinkedList[Int]) {
    l match {
      case LinkedList(0) => l.next = l
      case LinkedList(0, _*) => {
        l.elem = l.next.elem
        l.next = l.next.next
        rmZeroes(l)
      }
      case LinkedList(_, _*) => rmZeroes(l.next)
      case _ => ()
    }
  }

  val l1 = LinkedList(0,0,1,6,5,0,99,0,8)
  rmZeroes(l1)
  assert(l1 == LinkedList(1,6,5,99,8))

  val l2 = LinkedList(0)
  rmZeroes(l2)
  assert(l2 == LinkedList())

}
