def hasZeroRow(m: List[List[Int]]) =
    m exists (row => row forall (_ == 0))
