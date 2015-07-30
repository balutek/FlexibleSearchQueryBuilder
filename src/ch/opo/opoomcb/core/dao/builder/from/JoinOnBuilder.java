package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.model.On;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.operation.Bracket;
import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;
import ch.opo.opoomcb.core.dao.builder.whereSegment.ParamBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class JoinOnBuilder
{
   private QueryModel queryModel;

   private ParamJoinBuilder paramJoinBuilder;

   private OperatorJoinBuilder operatorJoinBuilder;

   private List<Operation> operationList;

   private List<Bracket> bracketList;

   public JoinOnBuilder(QueryModel queryModel, ParamJoinBuilder paramJoinBuilder)
   {
      this.queryModel = queryModel;
      this.paramJoinBuilder = paramJoinBuilder;
      this.operatorJoinBuilder = new OperatorJoinBuilder(this);
      operationList = new ArrayList<Operation>();
      bracketList = new ArrayList<Bracket>();
   }

   public void insertOperationWithParam(Operation operation, String key, Object param)
   {
      queryModel.putQueryParam(key, param);
      insertOperation(operation);
   }

   public void insertOperation(Operation operation)
   {
      if (bracketList.size() > 0)
      {
         bracketList.get(bracketList.size() - 1).addOperation(operation);
      }
      else
      {
         operationList.add(operation);
      }
   }

   public void openBracket()
   {
      bracketList.add(new Bracket());
   }

   public void closeBracket()
   {
      if (bracketList.size() > 0)
      {
         Bracket bracket = bracketList.remove(bracketList.size() - 1);

         insertOperation(bracket);
      }
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