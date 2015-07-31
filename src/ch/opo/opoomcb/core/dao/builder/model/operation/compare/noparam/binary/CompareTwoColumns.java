package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.SPACE;

/**
 * @author Paweł Łabuda
 */
public abstract class CompareTwoColumns extends CompareOperation
{
   private Column firstColumn;

   private Column secondColumn;

   public CompareTwoColumns(Column firstColumn, Column secondColumn)
   {
      super();

      this.firstColumn = firstColumn;
      this.secondColumn = secondColumn;
   }

   @Override
   public void render(StringBuilder builder)
   {
      firstColumn.render(builder);
      builder.append(SPACE)
         .append(getComparisonOperation())
         .append(SPACE);
      secondColumn.render(builder);
   }
}
