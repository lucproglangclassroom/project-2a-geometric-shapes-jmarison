package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestHeight extends AnyFunSuite:

  def t(desc: String, s: Shape, expected: Int): Unit =
    test(desc):
      assert(height(s) == expected)

  t("ellipse height", simpleEllipse, 1)
  t("rectangle height", simpleRectangle, 1)
  t("location height", simpleLocation, 2)
  t("basic group height", basicGroup, 2)
  t("simple group height", simpleGroup, 2)
  t("complex group height", complexGroup, 4)

end TestHeight
