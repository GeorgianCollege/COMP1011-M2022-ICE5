package ca.georgiancollege.comp1011m2022ice5;

/**
 * @author Tom Tsiliopoulos
 */
public class Vector2D
{
    // Private Instance Members
    private int m_id;
    private float m_x;
    private float m_y;

    // Constructors
    /**
     * Default constructor
     * - set x and y components to 0.0f and id to -1
     */
    public Vector2D()
    {
        m_id = -1;
        setX(0.0f);
        setY(0.0f);
    }

    /**
     * This constructor takes x and y parameters
     * - id is set to -1
     * @param x
     * @param y
     */
    public Vector2D(float x, float y)
    {
        m_id = -1;
        setX(x);
        setY(y);
    }

    public Vector2D(int id, float x, float y)
    {
        this(x, y);
        setID(id);
    }

    // Public Properties (Getters and Setters)

    public int getID()
    {
        return m_id;
    }

    public void setID(int id)
    {
        if(id < 0)
        {
            throw new IllegalArgumentException("Vector ID must be greater than zero");
        }
        else
        {
            m_id = id;
        }
    }

    public float getY()
    {
        return m_y;
    }

    public void setY(float new_y)
    {
        m_y = new_y;
    }

    public float getX()
    {
        return m_x;
    }

    public void setX(float new_x)
    {
        m_x = new_x;
    }

    // Computed read-only Property
    public float getMagnitude()
    {
        return Utility.Instance().Distance(new Vector2D(0.0f, 0.0f), this);
    }

    // Public Methods

    /**
     * This method adds a Vector2D to this Vector2D
     *
     * @param vector
     * @return
     */
    public Vector2D add(Vector2D vector)
    {
        m_x += vector.getX();
        m_y += vector.getY();
        return this;
    }

    /**
     * @param vector
     * @return
     */
    public Vector2D subtract(Vector2D vector)
    {
        m_x = vector.getX() - m_x;
        m_y = vector.getY() - m_y;
        return this;
    }

    public String toOneDecimalString()
    {
        var x = String.format("%.1f", getX());
        var y = String.format("%.1f", getY());
        return ("(" + x + ", " + y + ")");
    }

    // Overridden Methods
    @Override
    public String toString()
    {
        return ("(" + getX() + ", " + getY() + ")");
    }
}