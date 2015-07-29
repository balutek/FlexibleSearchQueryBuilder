/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model.operation;

import java.util.ArrayList;
import java.util.List;

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

}
