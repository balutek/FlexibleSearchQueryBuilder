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
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class On implements Renderable
{
   protected List<Operation> operationList;

   public On()
   {
      operationList = new ArrayList<Operation>();
   }

   public On(List<Operation> operationList)
   {
      this.operationList = operationList;
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
   public StringBuilder render(StringBuilder builder)
   {

      return builder;
   }
}
