/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.render;

import ch.opo.opoomcb.core.dao.builder.model.*;
import ch.opo.opoomcb.core.dao.builder.model.operation.Bracket;
import ch.opo.opoomcb.core.dao.builder.model.operation.Not;
import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.And;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.BitwiseOperation;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.Or;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */
public class QueryRenderer
{
   private QueryRenderer()
   {
   }

   public static String render(Renderable renderable)
   {
      StringBuilder builder = new StringBuilder();
      renderable.render(builder);
      return builder.toString();
   }

   /*
   private String build()
   {
      resultQuery = new StringBuilder();
      renderSelect(model.getLastSelect()); // todo change this
      return resultQuery.toString();
   }

   private void renderSelect(Select select)
   {
      resultQuery.append(SELECT).append(SPACE);

      renderSelectedColumns(select);

      for (From from : select.getFromList())
      {
         renderFrom(from);
      }
   }

   private void renderSelectedColumns(Select select)
   {
      Iterator<Column> columnIterator = select.getColumnList().iterator();
      while (columnIterator.hasNext())
      {
         renderColumn(columnIterator.next());
         if (columnIterator.hasNext())
         {
            resultQuery.append(TABLE_SEPARATOR);
         }
      }
   }

   private void renderColumn(Column column)
   {
      String columnAlias = column.getAlias();
      resultQuery.append(OPEN_CURLY_BRACKET);
      if (StringUtils.isNotBlank(columnAlias))
      {
         resultQuery.append(columnAlias).append(ALIAS_SEPARATOR);
      }
      resultQuery.append(column.getName()).append(CLOSE_CURLY_BRACKET);
   }

   private void renderFrom(From from)
   {
      Table fromTable = from.getTable();
      resultQuery.append(FROM).append(OPEN_CURLY_BRACKET);
      renderTable(fromTable);
      resultQuery.append(SPACE);
      for (Join join : from.getJoinList())
      {
         renderJoin(join);
      }
      resultQuery.append(CLOSE_CURLY_BRACKET);
   }

   private void renderTable(Table table)
   {
      resultQuery.append(table.getName());
      String fromTableAlias = table.getAlias();
      if (StringUtils.isNotBlank(fromTableAlias))
      {
         resultQuery.append(SPACE).append(AS).append(SPACE).append(fromTableAlias);
      }
   }

   private void renderJoin(Join join)
   {
      resultQuery.append(JOIN).append(SPACE);
      renderTable(join.getTable());
      resultQuery.append(SPACE);
      renderOn(join.getOn());
   }

   private void renderOn(On on)
   {
      resultQuery.append(ON).append(SPACE);
      renderOperationList(on.getOperationList());
   }

   private void renderOperationList(List<Operation> operationList)
   {
      for (Operation operation : operationList)
      {
         if (operation instanceof BitwiseOperation)
         {
            renderBitwiseOperation((BitwiseOperation) operation);
         }
         else if (operation instanceof CompareOperation)
         {
            renderCompareOperation((CompareOperation) operation);
         }
         else if (operation instanceof Bracket)
         {
            renderBracket((Bracket) operation);
         }
         else if (operation instanceof Not)
         {

         }
         resultQuery.append(SPACE);
      }
   }

   private void renderBracket(Bracket bracket)
   {

   }

   private static class Command<T extends Operation>
   {
      public void execute(T operation)
      {

      }
   }

   private void renderBitwiseOperation(BitwiseOperation bitwiseOperation)
   {
      if (bitwiseOperation instanceof And)
      {
         resultQuery.append(AND);
      }
      else if (bitwiseOperation instanceof Or)
      {
         resultQuery.append(OR);
      }
   }

   private void renderCompareOperation(CompareOperation compareOperation)
   {

   }

*/
}
