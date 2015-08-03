/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */
public class Where implements Renderable
{
   private List<Operation> operationList;

   public Where()
   {
      operationList = new ArrayList<Operation>();
   }

   public void setOperationList(List<Operation> operationList)
   {
      this.operationList = operationList;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(WHERE)
         .append(SPACE);

      Iterator<Operation> iterator = operationList.iterator();
      while (iterator.hasNext())
      {
         iterator.next().render(builder);
         if (iterator.hasNext())
         {
            builder.append(SPACE);
         }
      }
   }
}
