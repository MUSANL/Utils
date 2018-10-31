public class DisplayFieldInfo {
    public int ID;
    public int componentID;
    public String tableField;
    public String classField;
    public String tableName;
    public String className;
    public int dataType;   // must
    public String displayName;
    public int displayOrder;
    public int categoryID;
    public int tabID;
    public int entityUIID;
    public String gridEditor;
    public String styler;   //must
    public double precision;
    public double width;
    public int maxLength;
    public boolean fixedOnGrid; //must
    public String comboItems;   //must
    public boolean isReadOnly;
    public int align;
    public boolean isVisible;
    public String semantics;
    public String semanticsField;
    public String semanticsRole;

    public DisplayFieldInfo() {
        this.ID = 0;
        this.componentID = 0;
        this.tableField = "";
        this.classField = "";
        this.tableName = "";
        this.className = "";
        this.dataType = 0;
        this.displayName = "";
        this.gridEditor = "";
        this.displayOrder = 0;
        this.categoryID = 0;
        this.tabID = 0;
        this.entityUIID = 0;
        this.styler = "";
        this.precision = 2;
        this.width = 100;
        this.maxLength = 2;
        this.fixedOnGrid = false;
        this.comboItems = "";
        this.isReadOnly = false;
        this.align = 1;
        this.isVisible = true;
        this.semantics = "";
        this.semanticsField = "";
        this.semanticsRole = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getComponentID() {
        return componentID;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    public String getTableField() {
        return tableField;
    }

    public void setTableField(String tableField) {
        this.tableField = tableField;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getTabID() {
        return tabID;
    }

    public void setTabID(int tabID) {
        this.tabID = tabID;
    }

    public int getEntityUIID() {
        return entityUIID;
    }

    public void setEntityUIID(int entityUIID) {
        this.entityUIID = entityUIID;
    }

    public String getGridEditor() {
        return gridEditor;
    }

    public void setGridEditor(String gridEditor) {
        this.gridEditor = gridEditor;
    }

    public String getStyler() {
        return styler;
    }

    public void setStyler(String styler) {
        this.styler = styler;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean getFixedOnGrid() {
        return fixedOnGrid;
    }

    public void setFixedOnGrid(boolean fixedOnGrid) {
        this.fixedOnGrid = fixedOnGrid;
    }

    public String getComboItems() {
        return comboItems;
    }

    public void setComboItems(String comboItems) {
        this.comboItems = comboItems;
    }

    public boolean getIsReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    public String getSemanticsField() {
        return semanticsField;
    }

    public void setSemanticsField(String semanticsField) {
        this.semanticsField = semanticsField;
    }

    public String getSemanticsRole() {
        return semanticsRole;
    }

    public void setSemanticsRole(String semanticsRole) {
        this.semanticsRole = semanticsRole;
    }
}
