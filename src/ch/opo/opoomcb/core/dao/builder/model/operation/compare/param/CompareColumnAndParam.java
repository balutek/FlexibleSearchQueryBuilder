package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Key;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;


/**
 * @author Paweł Łabuda
 */
public abstract class CompareColumnAndParam extends CompareOperation
{
   private Column column;

   private Key key;

   public CompareColumnAndParam(Column column, Key key)
   {
      this.column = column;
      this.key = key;
   }

   @Override
   public void render(StringBuilder builder)
   {
      column.render(builder);
      builder.append(SPACE)
         .append(getComparisonOperation())
         .append(SPACE)
         .append(VALUE_PARAM_PREFIX);
      key.render(builder);
   }
}
