package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.model.On;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;
import ch.opo.opoomcb.core.dao.builder.whereSegment.ParamBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class JoinOnBuilder
{
   private StringBuilder query;

   private QueryModel queryModel;

   private ParamJoinBuilder paramJoinBuilder;

   private OperatorJoinBuilder operatorJoinBuilder;

   private List<Operation> operationList;

   private int bracketCount = 0;

   public JoinOnBuilder(QueryModel queryModel, ParamJoinBuilder paramJoinBuilder)
   {
      this.queryModel = queryModel;
//                .append(QueryElements.ON)
//                .append(QueryElements.OPEN_BRACKET);
      this.paramJoinBuilder = paramJoinBuilder;
      this.operatorJoinBuilder = new OperatorJoinBuilder(this);
      operationList = new ArrayList<Operation>();
   }

   public void insertOperationWithParam(Operation operation, String key, Object param)
   {
      queryModel.putQueryParam(key, param);
      operationList.add(operation);
   }

   public void insertOperation(Operation operation)
   {
      operationList.add(operation);
   }

   public void insertRestrictionWithOperator(String alias1, String param1, String alias2, String param2, String operator)
   {
      query.append(QueryElements.KEY_PARAM_PREFIX)
         .append(alias1)
         .append(".")
         .append(param1)
         .append(QueryElements.KEY_PARAM_SUFFIX)
         .append(" ")
         .append(operator)
         .append(" ")
         .append(QueryElements.KEY_PARAM_PREFIX)
         .append(alias2)
         .append(".")
         .append(param2)
         .append(QueryElements.KEY_PARAM_SUFFIX);
   }

   public void insertRestrictionWithNull(String alias, String param, String nullQuery)
   {
      query.append(QueryElements.KEY_PARAM_PREFIX)
         .append(alias)
         .append(".")
         .append(param)
         .append(QueryElements.KEY_PARAM_SUFFIX)
         .append(" ")
         .append(nullQuery);
   }

   public void insertOperator(QueryElements element)
   {
      query.append(element);
   }

   public void openBracket()
   {
      bracketCount++;
      query.append(QueryElements.OPEN_BRACKET);
   }

   public void closeBracket()
   {
      bracketCount--;
      if (bracketCount < 0)
      {
         bracketCount = 0;
      }
      else
      {
         query.append(QueryElements.CLOSE_BRACKET);
      }
   }

   public void closeJoinBuilder()
   {
      query.append(QueryElements.CLOSE_BRACKET);
   }

   public ParamJoinBuilder getParamJoinBuilder()
   {
      return paramJoinBuilder;
   }

   public OperatorJoinBuilder getOperatorJoinBuilder()
   {
      return operatorJoinBuilder;
   }

   public ParamBuilder getParamBuilder()
   {
      queryModel
         .getLastFrom()
         .getLastJoin()
         .setOn(
            new On(operationList)
         );
      return new ParamBuilder(queryModel);
   }

   public String createKey(String name)
   {
      return queryModel.createKey(name);
   }
}