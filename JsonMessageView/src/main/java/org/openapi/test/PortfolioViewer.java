package org.openapi.test;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.openapi.common.AccInfo;
import org.openapi.common.CommonHeader;
import org.openapi.portfolio.PortfolioList;
import org.openapi.portfolio.PortfolioResponse;
import org.openapi.portfolio.PortfolioResponseBody;
import org.openapi.portfolio.QueryType;
import org.openapi.portfolio.asset.Amount;
import org.openapi.portfolio.asset.Equity;
import org.openapi.portfolio.asset.Etc;
import org.openapi.portfolio.asset.Fund;
import org.openapi.transaction.QueryResult;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by heungjae on 2016-07-07.
 */
public class PortfolioViewer {

    public static void main(String[] args) {

        String jsonMsg = "{\"commonHeader\":{\"reqIdPlatform\":\"test1\",\"reqIdConsumer\":\"string\",\"certDn\":\"cn\\u003d홍길동-13491629,ou\\u003dHTS,ou\\u003dNH투자,ou\\u003d증권,o\\u003dSignKorea,c\\u003dKR\",\"ci\":\"S1V7HGXBV1EPGBJasoZf4fQV+eOpOc1pfizByV6UIEYJHM/PF9QKu+PU2OThEog7QmVKSZNibNGg+/k0XB/9jQ\\u003d\\u003d\"},\"portfolioResponseBody\":{\"accInfo\":{\"vtAccNo\":\"160678007213500001\"},\"queryType\":{\"assetType\":\"FUND\",\"rspType\":\"RAT\",\"count\":\"0\",\"page\":\"null\"},\"queryResult\":{\"totalCnt\":7.0,\"count\":7.0,\"page\":\"null\"}},\"portfolioList\":{\"portfolio\":[{\"cash\":{\"amt\":0.0}},{\"fundList\":[{\"fundCode\":\"KRZ500395135\",\"fundName\":\"삼성중소형FOCUS증권자1호[주식]\",\"qty\":46.0,\"earningRate\":-9.58,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ500395136\",\"fundName\":\"삼성중소형FOCUS증권자1호[주식]\",\"qty\":5.0,\"earningRate\":-12.52,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501130561\",\"fundName\":\"미래에셋고배당포커스>증권자1호(\",\"qty\":5.0,\"earningRate\":-6.32,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501151101\",\"fundName\":\"동양중소형고배당증권자1호(주식\",\"qty\":5.0,\"earningRate\":-10.35,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501798293\",\"fundName\":\"미래에셋한국헬스케어증권자1호(\",\"qty\":12.0,\"earningRate\":-4.26,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501798297\",\"fundName\":\"미래에셋한국헬스케어증권자1호(\",\"qty\":18.0,\"earningRate\":-3.82,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501831185\",\"fundName\":\"메리츠코리아증권투자신탁1호[주\",\"qty\":5.0,\"earningRate\":-15.83,\"maturity\":\"00000000\"}]}]},\"resp\":{\"respCode\":\"200\",\"respMsg\":\"OK\"}}\n";
        Gson gson = new Gson();
        PortfolioResponse portfolioResponse = gson.fromJson(jsonMsg, PortfolioResponse.class);

        CommonHeader commonHeader = portfolioResponse.getCommonHeader();
        System.out.println("-------------------------------------");
        System.out.println("DN = " + commonHeader.getCertDn());

        PortfolioResponseBody portfolioResponseBody = portfolioResponse.getPortfolioResponseBody();
        AccInfo accInfo = portfolioResponseBody.getAccInfo();

        System.out.println("실계좌번호 = " + accInfo.getRealAccNo());
        System.out.println("가상계좌번호 = " + accInfo.getVtAccNp());

        QueryType queryType = portfolioResponseBody.getQueryType();
        boolean isRatType = false;
        if (queryType.getRspType().equals("RAT")) {
            isRatType = true;
        }

        QueryResult queryResult = portfolioResponseBody.getQueryResult();
        System.out.println("-------------------------------------");
        System.out.println("조회결과:총건수= " + queryResult.getTotalCnt());
        System.out.println("조회결과:금번건수= " + queryResult.getCount());
        if (queryResult.getPage() == null || queryResult.getPage().equals("null")) {
            System.out.println("더이상 조회할 페이지가 없습니다.");
        } else if (queryResult.getPage() != null) {
            System.out.println("다음 페이지의 키 = [" + queryResult.getPage() + "]");
        } else {
            System.out.println("더이상 조회할 페이지가 없습니다.");
        }
        PortfolioList portfolioList = portfolioResponse.getPortfolioList();

        JsonParser parser = new JsonParser();
        JsonObject data = parser.parse(jsonMsg).getAsJsonObject().getAsJsonObject("portfolioList");
        JsonArray array = data.getAsJsonArray("portfolio");
        int equityCnt = 0, fundCnt = 0, etcCnt = 0;
        for (JsonElement je1 : array) {
            if (je1.getAsJsonObject().get("cash") != null) {
                Amount amt = gson.fromJson(je1.getAsJsonObject().get("cash"), Amount.class);
                System.out.println("-------------------------------------");
                System.out.println("계좌내현금 - " + new BigDecimal(amt.getAmt()));
            } else if (je1.getAsJsonObject().get("equityList") != null) {
                Type listType = new TypeToken<ArrayList<Equity>>() {
                }.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("equityList"), listType);
                System.out.println("-------------------------------------");
                equityCnt = arrayList.size();
                System.out.println("Equity 상품군 종목수 = [" + equityCnt + "]");
                double sum = 0.0;
                for (Object object : arrayList) {
                    Equity equity = (Equity) object;
                    System.out.println("-------------------------------------");
                    System.out.println("상품구분 - [" + equity.getAssetType() + "]");
                    System.out.println("종목코드 - [" + equity.getIsinCode() + "]");
                    if (isRatType)
                        System.out.println("보유비율 - [" + equity.getQty() + "]%");
                    else
                        System.out.println("보유수량 - [" + new BigDecimal(equity.getQty()) + "]주");
                    System.out.println("수익률 - [" + equity.getEarningRate() + "%]");
                    sum += equity.getQty();
                }
                System.out.println("-------------------------------------");
                if (isRatType) System.out.println("Equity 상품군 누적보유비율 = [" + sum + "]");
            } else if (je1.getAsJsonObject().get("fundList") != null) {
                Type listType = new TypeToken<ArrayList<Fund>>() {
                }.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("fundList"), listType);
                System.out.println("-------------------------------------");
                fundCnt = arrayList.size();
                System.out.println("fundList 상품군 종목수 = [" + fundCnt + "]");
                double sum = 0.0;
                for (Object object : arrayList) {
                    Fund fund = (Fund) object;
                    System.out.println("-------------------------------------");
                    System.out.println("펀드코드 - [" + fund.getFundCode() + "]");
                    System.out.println("펀드이름 - [" + fund.getFundName() + "]");
                    if (isRatType)
                        System.out.println("보유비율 - [" + fund.getQty() + "]%");
                    else
                        System.out.println("보유수량 - [" + new BigDecimal(fund.getQty()) + "]주");
                    System.out.println("수익률 - [" + fund.getEarningRate() + "%]");
                    System.out.println("만기일 - [" + fund.getMaturity() + "]");
                    sum += fund.getQty();
                }
                System.out.println("-------------------------------------");
                if (isRatType) System.out.println("Fund 상품군 누적보유비율 = [" + sum + "]");
            } else if (je1.getAsJsonObject().get("etcList") != null) {
                Type listType = new TypeToken<ArrayList<Etc>>() {
                }.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("etcList"), listType);
                System.out.println("-------------------------------------");
                etcCnt = arrayList.size();
                System.out.println("etcList 상품군 종목수 = [" + etcCnt + "]");
                double sum = 0.0;
                for (Object object : arrayList) {
                    Etc etc = (Etc) object;
                    System.out.println("-------------------------------------");
                    System.out.println("상품구분 - [" + etc.getAssetType() + "]");
                    System.out.println("상품이름 - [" + etc.getAssetName() + "]");

                    if (isRatType)
                        System.out.println("보유비율 - [" + etc.getQty() + "]%");
                    else
                        System.out.println("보유수량 - [" +new BigDecimal( etc.getQty()) + "]주");
                    System.out.println("수익률 - [" + etc.getEarningRate() + "%]");
                    sum += etc.getQty();
                }
                System.out.println("-------------------------------------");
                if (isRatType) System.out.println("ETC 상품군 누적보유비율 = [" + sum + "]");
            }
        }
        {
            int totalCntInMsg = equityCnt + fundCnt + etcCnt;
            System.out.println("-------------------------------------");
            System.out.println("이번 메시지 내 총 종목건수 - [" + totalCntInMsg + "]");
            if (totalCntInMsg - queryResult.getCount() != 0) {
                System.out.println("보낼 종목수와 받은 종목수가 차이가 있음");
            }
        }
    }
}
