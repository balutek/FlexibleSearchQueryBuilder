/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;


/**
 * @author Paweł Łabuda
 */
public class Bracket extends Operation
{
   protected List<Operation> operationList;

   public Bracket()
   {
      super();

      operationList = new ArrayList<Operation>();
   }

   public void addOperation(Operation operation)
   {
      operationList.add(operation);
   }

   public List<Operation> getOperationList()
   {
      return operationList;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(OPEN_PARENTHESIS);

      Iterator<Operation> iterator = operationList.iterator();
      while (iterator.hasNext())
      {
         iterator.next().render(builder);
         if (iterator.hasNext())
         {
            builder.append(SPACE);
         }
      }
      builder.append(CLOSE_PARENTHESIS);
   }
}
