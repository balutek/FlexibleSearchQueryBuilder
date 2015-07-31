package ch.opo.opoomcb.core.dao.builder.builders.from;

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
public class CompareJoinBuilder
{
   private JoinOnBuilder builder;

   public CompareJoinBuilder(QueryModel queryModel)
   {
      builder = new JoinOnBuilder(queryModel, this);
   }

   public BitwiseJoinBuilder isNull(String alias, String column)
   {
      Operation operation = new IsNull(new Column(column, alias));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder isNotNull(String alias, String column)
   {
      Operation operation = new IsNotNull(new Column(column, alias));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder lessThan(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new LessParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder lessThan(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new Less(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder lessOrEqualsThan(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new LessOrEqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder lessOrEqualsThan(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new LessOrEquals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder greaterThan(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new GreaterParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder greaterThan(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new Greater(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder greaterOrEqualsThan(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new GreaterOrEqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder greaterOrEqualsThan(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new GreaterOrEquals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder startWith(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param + '%');
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder endWith(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, '%' + param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder contains(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, '%' + param + '%');
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder like(String alias, String column, String param)
   {
      String key = creteKey(column);
      Operation operation = new Like(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder equals(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new EqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder equals(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new Equals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder notEquals(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new NotEqualsParam(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder notEquals(String alias1, String column1, String alias2, String column2)
   {
      Operation operation = new NotEquals(new Column(column1, alias1), new Column(column2, alias2));
      builder.insertOperation(operation);
      return builder.getBitwiseJoinBuilder();
   }

   public BitwiseJoinBuilder isIn(String alias, String column, Object param)
   {
      String key = creteKey(column);
      Operation operation = new In(new Column(column, alias), new Param(key));
      builder.insertOperationWithParam(operation, key, param);
      return builder.getBitwiseJoinBuilder();
   }

   public CompareJoinBuilder openBracket()
   {
      builder.openBracket();
      return builder.getCompareJoinBuilder();
   }

   private String creteKey(String name)
   {
      return builder.createKey(name);
   }
}
