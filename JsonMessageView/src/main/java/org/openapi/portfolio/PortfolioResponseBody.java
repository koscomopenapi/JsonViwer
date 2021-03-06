/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openapi.portfolio;

import java.util.Objects;
import org.openapi.common.AccInfo;
import org.openapi.transaction.QueryResult;

/**
 *
 * @author heungjae
 */
public class PortfolioResponseBody {

    AccInfo accInfo;
    QueryType queryType;
    QueryResult queryResult;

    public PortfolioResponseBody() {
    }

    public AccInfo getAccInfo() {
        return accInfo;
    }

    public void setAccInfo(AccInfo accInfo) {
        this.accInfo = accInfo;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.accInfo);
        hash = 19 * hash + Objects.hashCode(this.queryType);
        hash = 19 * hash + Objects.hashCode(this.queryResult);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PortfolioResponseBody other = (PortfolioResponseBody) obj;
        if (!Objects.equals(this.accInfo, other.accInfo)) {
            return false;
        }
        if (!Objects.equals(this.queryType, other.queryType)) {
            return false;
        }
        if (!Objects.equals(this.queryResult, other.queryResult)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PortfolioResponseBody{" + "accInfo=" + accInfo + ", queryType=" + queryType + ", queryResult=" + queryResult + '}';
    }


}
