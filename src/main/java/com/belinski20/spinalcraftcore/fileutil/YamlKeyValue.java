package com.belinski20.spinalcraftcore.fileutil;

public class YamlKeyValue {

    private String path;
    private Object value;

    public YamlKeyValue(String path, Object value)
    {
        this.path = path;
        this.value = value;
    }

    public String getPath()
    {
        return path;
    }

    public Object getValue()
    {
        return value;
    }

    /**
     * This compares an object and the current YamlKeyValue
     * This can use a YamlKeyValue or a String for the comparison
     * This uses path you are looking for as the value
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof YamlKeyValue)
        {
            return this.path.equals(((YamlKeyValue) obj).path);
        }
        if(obj instanceof String)
        {
            return this.path.equals(obj);
        }
        return false;
    }

}
