/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation.compare;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class Equals extends CompareOperation
{
   private Column firstColumn;

   private Column secondColumn;

   public Equals(Column firstColumn, Column secondColumn)
   {
      super();

      this.firstColumn = firstColumn;
      this.secondColumn = secondColumn;
   }

   public Column getFirstColumn()
   {
      return firstColumn;
   }

   public Column getSecondColumn()
   {
      return secondColumn;
   }
}
