/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Key;

/**
 * @author Paweł Łabuda
 */
public class EqualsParam extends CompareColumnAndParam
{
   public EqualsParam(Column column, Key key)
   {
      super(column, key);
   }
}
