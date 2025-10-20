package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  def t(desc: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(desc):
      assert(scale(s, factor) == expected)

  t("scale ellipse", simpleEllipse, 0.5, Ellipse(25, 15))
  t("scale rectangle", simpleRectangle, 2.0, Rectangle(160, 240))
  t("scale location", simpleLocation, 2.0, Location(140, 60, Rectangle(160, 240)))

end TestScale
