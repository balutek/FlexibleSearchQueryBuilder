/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class Equals extends CompareTwoColumns
{
   public Equals(Column firstColumn, Column secondColumn)
   {
      super(firstColumn, secondColumn);
   }
}
