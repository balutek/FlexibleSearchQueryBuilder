/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.exception;

/**
 * @author Paweł Łabuda
 */
public class QueryBuilderException extends Exception
{
   public QueryBuilderException()
   {
      super();
   }

   public QueryBuilderException(String message)
   {
      super(message);
   }

   public QueryBuilderException(String message, Throwable cause)
   {
      super(message, cause);
   }

   public QueryBuilderException(Throwable cause)
   {
      super(cause);
   }
}
