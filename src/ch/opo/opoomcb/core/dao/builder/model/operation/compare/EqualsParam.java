/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation.compare;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Param;

/**
 * @author Paweł Łabuda
 */
public class EqualsParam extends CompareOperation
{
   private Column column;

   private Param parameter;

   public EqualsParam(Column column, Param parameter)
   {
      this.column = column;
      this.parameter = parameter;
   }

   public Column getColumn()
   {
      return column;
   }

   public Param getParameter()
   {
      return parameter;
   }
}
