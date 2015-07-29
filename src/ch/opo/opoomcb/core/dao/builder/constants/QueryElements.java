/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.constants;

/**
 * @author Paweł Łabuda
 */
public enum QueryElements
{
   SELECT("SELECT "),
   FROM(" FROM "),
   WHERE(" WHERE "),
   ORDER_BY(" ORDER BY "),
   AND(" AND "),
   OR(" OR "),
   IN(" IN "),
   LIKE(" LIKE "),
   DISTINCT("DISTINCT "),
   AS(" AS "),
   RESULTS_SEPARATOR(","),
   KEY_PARAM_PREFIX("{"),
   KEY_PARAM_SUFIX("}"),
   VALUE_PARAM_PREFIX("?"),
   OPEN_BRACKET("("),
   CLOSE_BRACKET(")");

   public String code;

   QueryElements(final String code)
   {
      this.code = code;
   }

   @Override
   public String toString()
   {
      return code;
   }
}
