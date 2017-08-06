package com.blackybear.reverse;

import javax.persistence.*;

/**
 * Description:
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-02
 */
@Entity
@Table(name = "test")
public class Test {
    private int mTestId;
    private String mTestName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id", nullable = false)
    public int getTestId() {
        return mTestId;
    }

    public void setTestId(int testId) {
        mTestId = testId;
    }

    @Basic
    @Column(name = "test_name", nullable = true, length = 256)
    public String getTestName() {
        return mTestName;
    }

    public void setTestName(String testName) {
        mTestName = testName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (mTestId != test.mTestId) return false;
        if (mTestName != null ? !mTestName.equals(test.mTestName) : test.mTestName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mTestId;
        result = 31 * result + (mTestName != null ? mTestName.hashCode() : 0);
        return result;
    }
}
