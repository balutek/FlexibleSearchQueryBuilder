/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation.bitwise;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;

/**
 * @author Paweł Łabuda
 */
public class Or extends BitwiseOperation
{
   @Override
   public void render(StringBuilder builder)
   {
      builder.append(QueryElements.OR);
   }
}
