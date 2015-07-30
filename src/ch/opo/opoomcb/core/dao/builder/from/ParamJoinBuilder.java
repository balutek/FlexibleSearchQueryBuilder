package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Param;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary.*;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary.IsNotNull;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary.IsNull;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.param.*;

/**
 * @author Paweł Łabuda
 */
public class ParamJoinBuilder
{
   private JoinOnBuilder builder;

   public ParamJoinBuilder(QueryModel queryModel)
   {
      builder = new JoinOnBuilder(queryModel, this);
   }

   public OperatorJoinBuilder isNull(String alias, String column)
   {
      Operation operation = new IsNull(new Column(column, alias));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder isNotNull(String alias, String column)
   {
      Operation operation = new IsNotNull(new Column(column, alias));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder lesserThen(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new LesserParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder lesserThen(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new Lesser(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder lesserOrEqualsThen(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new LesserOrEqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder lesserOrEqualsThen(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new LesserOrEquals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder greaterThen(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new GreaterParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder greaterThen(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new Greater(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder greaterOrEqualsThen(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new GreaterOrEqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder greaterOrEqualsThen(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new GreaterOrEquals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder startWith(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param + '%'); //todo chyba zminic to
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder endWith(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, '%' + param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder contains(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, '%' + param + '%');
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder like(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder equals(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new EqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder equals(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new Equals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder notEquals(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new NotEqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getOperatorJoinBuilder();
   }

   public OperatorJoinBuilder notEquals(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new NotEquals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getOperatorJoinBuilder();
   }


//   public OperatorJoinBuilder isIn(String param, Object... values)
//   {
//      builder.insertRestrictionIn(param, values);
//      return builder.getOperatorJoinBuilder();
//   }
//
//   public OperatorJoinBuilder isIn(String param, Collection values)
//   {
//      builder.insertRestrictionIn(param, values);
//      return builder.getOperatorJoinBuilder();
//   }

   public ParamJoinBuilder openBracket()
   {
      builder.openBracket();
      return builder.getParamJoinBuilder();
   }

   private String creteKey(String name)
   {
      return builder.createKey(name);
   }
}
