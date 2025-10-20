package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestSize extends AnyFunSuite:

  def t(desc: String, s: Shape, expected: Int): Unit =
    test(desc):
      assert(size(s) == expected)

  t("ellipse size", simpleEllipse, 1)
  t("rectangle size", simpleRectangle, 1)
  t("location size", simpleLocation, 1)
  t("basic group size", basicGroup, 2)
  t("simple group size", simpleGroup, 2)
  t("complex group size", complexGroup, 5)

end TestSize
