package org.openapi.test;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.openapi.common.AccInfo;
import org.openapi.common.CommonHeader;
import org.openapi.portfolio.PortfolioList;
import org.openapi.portfolio.PortfolioResponse;
import org.openapi.portfolio.PortfolioResponseBody;
import org.openapi.portfolio.asset.Amount;
import org.openapi.portfolio.asset.Equity;
import org.openapi.portfolio.asset.Etc;
import org.openapi.portfolio.asset.Fund;
import org.openapi.transaction.QueryResult;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by heungjae on 2016-07-07.
 */
public class PortfolioViewer {

    public static void main(String[] args) {

        String jsonMsg = "{\"commonHeader\":{\"reqIdPlatform\":\"201606241533\",\"reqIdConsumer\":\"string\",\"certDn\":\"cn\\u003d김정식-13491629,ou\\u003dHTS,ou\\u003dNH투자,ou\\u003d증권,o\\u003dSignKorea,c\\u003dKR\",\"ci\":\"S1V7HGXBV1EPGBJasoZf4fQV+eOpOc1pfizByV6UIEYJHM/PF9QKu+PU2OThEog7QmVKSZNibNGg+/k0XB/9jQ\\u003d\\u003d\"},\"portfolioResponseBody\":{\"accInfo\":{\"realAccNo\":\"30001414535\",\"vtAccNo\":\"160678007213500001\"},\"queryType\":{\"assetType\":\"ALL\",\"rspType\":\"RAT\",\"count\":\"0\",\"page\":\"\"},\"queryResult\":{\"totalCnt\":162.0,\"count\":162.0,\"page\":\"null\"}},\"portfolioList\":{\"portfolio\":[{\"cash\":{\"amt\":6976542.0}},{\"equityList\":[{\"assetType\":\"KSP\",\"isinCode\":\"HK0000050325\",\"qty\":0.0,\"earningRate\":-12.9},{\"assetType\":\"KDQ\",\"isinCode\":\"HK0000054723\",\"qty\":0.0,\"earningRate\":-28.64},{\"assetType\":\"KSP\",\"isinCode\":\"KR7000020008\",\"qty\":0.0,\"earningRate\":5.35},{\"assetType\":\"KSP\",\"isinCode\":\"KR7000210005\",\"qty\":0.0,\"earningRate\":8.08},{\"assetType\":\"KSP\",\"isinCode\":\"KR7000270009\",\"qty\":0.0,\"earningRate\":-1.78},{\"assetType\":\"KSP\",\"isinCode\":\"KR7000400002\",\"qty\":0.0,\"earningRate\":-3.94},{\"assetType\":\"KSP\",\"isinCode\":\"KR7000880005\",\"qty\":0.0,\"earningRate\":1.82},{\"assetType\":\"KSP\",\"isinCode\":\"KR7001440007\",\"qty\":0.0,\"earningRate\":0.38},{\"assetType\":\"KSP\",\"isinCode\":\"KR7001570001\",\"qty\":0.0,\"earningRate\":51.6},{\"assetType\":\"KSP\",\"isinCode\":\"KR7001630003\",\"qty\":0.0,\"earningRate\":1.49},{\"assetType\":\"KSP\",\"isinCode\":\"KR7002020006\",\"qty\":0.0,\"earningRate\":3.16},{\"assetType\":\"KSP\",\"isinCode\":\"KR7002360006\",\"qty\":0.0,\"earningRate\":0.02},{\"assetType\":\"KSP\",\"isinCode\":\"KR7002630002\",\"qty\":0.0,\"earningRate\":-4.28},{\"assetType\":\"KSP\",\"isinCode\":\"KR7003060001\",\"qty\":0.0,\"earningRate\":-4.18},{\"assetType\":\"KSP\",\"isinCode\":\"KR7003520004\",\"qty\":0.0,\"earningRate\":5.09},{\"assetType\":\"KSP\",\"isinCode\":\"KR7004800009\",\"qty\":0.0,\"earningRate\":1.08},{\"assetType\":\"KSP\",\"isinCode\":\"KR7005090006\",\"qty\":0.0,\"earningRate\":5.53},{\"assetType\":\"KSP\",\"isinCode\":\"KR7005740006\",\"qty\":0.0,\"earningRate\":-9.41},{\"assetType\":\"KSP\",\"isinCode\":\"KR7005850003\",\"qty\":97.0,\"earningRate\":61.81},{\"assetType\":\"KSP\",\"isinCode\":\"KR7006120000\",\"qty\":0.0,\"earningRate\":-0.16},{\"assetType\":\"KSP\",\"isinCode\":\"KR7006340004\",\"qty\":0.0,\"earningRate\":1.46},{\"assetType\":\"KSP\",\"isinCode\":\"KR7006360002\",\"qty\":0.0,\"earningRate\":4.63},{\"assetType\":\"KSP\",\"isinCode\":\"KR7006400006\",\"qty\":0.0,\"earningRate\":2.8},{\"assetType\":\"KSP\",\"isinCode\":\"KR7006800007\",\"qty\":0.0,\"earningRate\":4.55},{\"assetType\":\"KSP\",\"isinCode\":\"KR7008771008\",\"qty\":0.0,\"earningRate\":-1.24},{\"assetType\":\"KSP\",\"isinCode\":\"KR7008930000\",\"qty\":0.0,\"earningRate\":5.22},{\"assetType\":\"KSP\",\"isinCode\":\"KR7009440009\",\"qty\":0.0,\"earningRate\":0.1},{\"assetType\":\"KSP\",\"isinCode\":\"KR7010140002\",\"qty\":0.0,\"earningRate\":-0.41},{\"assetType\":\"KSP\",\"isinCode\":\"KR7010420008\",\"qty\":0.0,\"earningRate\":-2.47},{\"assetType\":\"KSP\",\"isinCode\":\"KR7010950004\",\"qty\":0.0,\"earningRate\":2.55},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7011080009\",\"qty\":0.0,\"earningRate\":-5.43},{\"assetType\":\"KSP\",\"isinCode\":\"KR7011390002\",\"qty\":0.0,\"earningRate\":-5.76},{\"assetType\":\"ETC\",\"isinCode\":\"KR7012580007\",\"qty\":0.0,\"earningRate\":-88.51},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7014620009\",\"qty\":0.0,\"earningRate\":11.17},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7014940001\",\"qty\":0.0,\"earningRate\":2.53},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7016100000\",\"qty\":0.0,\"earningRate\":-4.75},{\"assetType\":\"KSP\",\"isinCode\":\"KR7016450009\",\"qty\":0.0,\"earningRate\":-9.75},{\"assetType\":\"KSP\",\"isinCode\":\"KR7017180001\",\"qty\":0.0,\"earningRate\":7.15},{\"assetType\":\"KSP\",\"isinCode\":\"KR7018260000\",\"qty\":0.0,\"earningRate\":-2.84},{\"assetType\":\"KSP\",\"isinCode\":\"KR7018470005\",\"qty\":0.0,\"earningRate\":-0.28},{\"assetType\":\"ETC\",\"isinCode\":\"KR7020920005\",\"qty\":0.0,\"earningRate\":-76.9},{\"assetType\":\"KSP\",\"isinCode\":\"KR7025560004\",\"qty\":0.0,\"earningRate\":4.33},{\"assetType\":\"KSP\",\"isinCode\":\"KR7028050003\",\"qty\":0.0,\"earningRate\":8.55},{\"assetType\":\"KSP\",\"isinCode\":\"KR7030200000\",\"qty\":0.0,\"earningRate\":3.36},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7030530000\",\"qty\":0.0,\"earningRate\":7.26},{\"assetType\":\"KSP\",\"isinCode\":\"KR7032830002\",\"qty\":0.0,\"earningRate\":-12.45},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7032940009\",\"qty\":0.0,\"earningRate\":5.84},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7035600006\",\"qty\":0.0,\"earningRate\":-19.04},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7035720002\",\"qty\":0.0,\"earningRate\":-14.66},{\"assetType\":\"KSP\",\"isinCode\":\"KR7036460004\",\"qty\":0.0,\"earningRate\":0.93},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7036540003\",\"qty\":0.0,\"earningRate\":4.94},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7037950003\",\"qty\":0.0,\"earningRate\":0.75},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7038460002\",\"qty\":0.0,\"earningRate\":-3.92},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7041140005\",\"qty\":0.0,\"earningRate\":4.23},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7041830001\",\"qty\":0.0,\"earningRate\":10.99},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7041920000\",\"qty\":0.0,\"earningRate\":0.29},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7043100007\",\"qty\":0.0,\"earningRate\":-0.99},{\"assetType\":\"KSP\",\"isinCode\":\"KR7047810007\",\"qty\":0.0,\"earningRate\":1.86},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7048530000\",\"qty\":0.0,\"earningRate\":3.8},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7048550008\",\"qty\":0.0,\"earningRate\":17.6},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7049180003\",\"qty\":0.0,\"earningRate\":-14.4},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7052710001\",\"qty\":0.0,\"earningRate\":-6.36},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7053110003\",\"qty\":0.0,\"earningRate\":-0.77},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7053280004\",\"qty\":0.0,\"earningRate\":-2.87},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7054210000\",\"qty\":0.0,\"earningRate\":-28.46},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7054780002\",\"qty\":0.0,\"earningRate\":3.59},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7058820002\",\"qty\":0.0,\"earningRate\":-0.64},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7059210005\",\"qty\":0.0,\"earningRate\":-12.59},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7060250008\",\"qty\":0.0,\"earningRate\":-10.03},{\"assetType\":\"KSP\",\"isinCode\":\"KR7060980000\",\"qty\":0.0,\"earningRate\":-25.54},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7063080006\",\"qty\":0.0,\"earningRate\":1.57},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7063170005\",\"qty\":0.0,\"earningRate\":-5.52},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7064260003\",\"qty\":0.0,\"earningRate\":2.5},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7064480007\",\"qty\":0.0,\"earningRate\":-3.22},{\"assetType\":\"KSP\",\"isinCode\":\"KR7064960008\",\"qty\":0.0,\"earningRate\":-1.0},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7065150005\",\"qty\":0.0,\"earningRate\":-37.07},{\"assetType\":\"KSP\",\"isinCode\":\"KR7066570003\",\"qty\":0.0,\"earningRate\":6.95},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7067080002\",\"qty\":0.0,\"earningRate\":1.38},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7068330000\",\"qty\":0.0,\"earningRate\":-19.93},{\"assetType\":\"KSP\",\"isinCode\":\"KR7068870005\",\"qty\":0.0,\"earningRate\":2.59},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7069080000\",\"qty\":0.0,\"earningRate\":5.72},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7076610005\",\"qty\":0.0,\"earningRate\":-15.66},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7078160009\",\"qty\":0.0,\"earningRate\":-12.28},{\"assetType\":\"KSP\",\"isinCode\":\"KR7078930005\",\"qty\":0.0,\"earningRate\":0.15},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7082270000\",\"qty\":0.0,\"earningRate\":0.0},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7083790006\",\"qty\":0.0,\"earningRate\":7.91},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7084370006\",\"qty\":0.0,\"earningRate\":-6.87},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7084990001\",\"qty\":0.0,\"earningRate\":-13.99},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7085670008\",\"qty\":0.0,\"earningRate\":0.99},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7086450004\",\"qty\":0.0,\"earningRate\":3.48},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7086900008\",\"qty\":0.0,\"earningRate\":4.06},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7090710005\",\"qty\":0.0,\"earningRate\":13.19},{\"assetType\":\"KSP\",\"isinCode\":\"KR7091090001\",\"qty\":0.0,\"earningRate\":-0.94},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7092040005\",\"qty\":0.0,\"earningRate\":-1.45},{\"assetType\":\"KSP\",\"isinCode\":\"KR7093230001\",\"qty\":0.0,\"earningRate\":-10.1},{\"assetType\":\"KSP\",\"isinCode\":\"KR7093240000\",\"qty\":0.0,\"earningRate\":-10.61},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7095910006\",\"qty\":0.0,\"earningRate\":4.94},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7096530001\",\"qty\":0.0,\"earningRate\":10.94},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7096640008\",\"qty\":0.0,\"earningRate\":11.63},{\"assetType\":\"KSP\",\"isinCode\":\"KR7101530004\",\"qty\":0.0,\"earningRate\":-23.05},{\"assetType\":\"KSP\",\"isinCode\":\"KR7102460003\",\"qty\":0.0,\"earningRate\":6.54},{\"assetType\":\"KSP\",\"isinCode\":\"KR7105630008\",\"qty\":0.0,\"earningRate\":-4.18},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7105740005\",\"qty\":0.0,\"earningRate\":-12.66},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7106520000\",\"qty\":0.0,\"earningRate\":-36.64},{\"assetType\":\"KSP\",\"isinCode\":\"KR7110570009\",\"qty\":0.0,\"earningRate\":3.71},{\"assetType\":\"ETF\",\"isinCode\":\"KR7122630007\",\"qty\":1.0,\"earningRate\":2.12},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7122870009\",\"qty\":0.0,\"earningRate\":-13.42},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7130960008\",\"qty\":0.0,\"earningRate\":0.73},{\"assetType\":\"ETC\",\"isinCode\":\"KR7140310004\",\"qty\":0.0,\"earningRate\":-71.21},{\"assetType\":\"ETC\",\"isinCode\":\"KR7140320003\",\"qty\":0.0,\"earningRate\":-75.73},{\"assetType\":\"KSP\",\"isinCode\":\"KR7155900004\",\"qty\":0.0,\"earningRate\":-14.71},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7175140003\",\"qty\":0.0,\"earningRate\":0.46},{\"assetType\":\"KSP\",\"isinCode\":\"KR7185750007\",\"qty\":0.0,\"earningRate\":-11.56},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7187790001\",\"qty\":0.0,\"earningRate\":49.14},{\"assetType\":\"KDQ\",\"isinCode\":\"KR7236200002\",\"qty\":0.0,\"earningRate\":2.69},{\"assetType\":\"KDQ\",\"isinCode\":\"KYG210AT1036\",\"qty\":0.0,\"earningRate\":0.39},{\"assetType\":\"KDQ\",\"isinCode\":\"USU652221081\",\"qty\":0.0,\"earningRate\":9.47}]},{\"fundList\":[{\"fundCode\":\"KRZ500395135\",\"fundName\":\"삼성중소형FOCUS증권자1호[주식]\",\"qty\":46.0,\"earningRate\":-9.49,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ500395136\",\"fundName\":\"삼성중소형FOCUS증권자1호[주식]\",\"qty\":5.0,\"earningRate\":-12.42,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501130561\",\"fundName\":\"미래에셋고배당포커스증권자1호(\",\"qty\":5.0,\"earningRate\":-6.62,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501151101\",\"fundName\":\"동양중소형고배당증권자1호(주식\",\"qty\":5.0,\"earningRate\":-9.77,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501798293\",\"fundName\":\"미래에셋한국헬스케어증권자1호(\",\"qty\":12.0,\"earningRate\":-4.59,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501798297\",\"fundName\":\"미래에셋한국헬스케어증권자1호(\",\"qty\":18.0,\"earningRate\":-4.17,\"maturity\":\"00000000\"},{\"fundCode\":\"KRZ501831185\",\"fundName\":\"메리츠코리아증권투자신탁1호[주\",\"qty\":5.0,\"earningRate\":-15.38,\"maturity\":\"00000000\"}]},{\"etcList\":[{\"assetType\":\"BOND\",\"assetName\":\"국민주택1종11-07\",\"qty\":3.0,\"earningRate\":22.7},{\"assetType\":\"BOND\",\"assetName\":\"국고03000-2409(14-5)\",\"qty\":3.0,\"earningRate\":7.42},{\"assetType\":\"BOND\",\"assetName\":\"물가01500-2106(11-4)\",\"qty\":4.0,\"earningRate\":4.55},{\"assetType\":\"BOND\",\"assetName\":\"광주지방채11\",\"qty\":2.0,\"earningRate\":4.4},{\"assetType\":\"BOND\",\"assetName\":\"한국전력828\",\"qty\":3.0,\"earningRate\":4.68},{\"assetType\":\"BOND\",\"assetName\":\"한국전력891\",\"qty\":3.0,\"earningRate\":3.15},{\"assetType\":\"BOND\",\"assetName\":\"도로공사561\",\"qty\":3.0,\"earningRate\":2.75},{\"assetType\":\"BOND\",\"assetName\":\"도로공사537\",\"qty\":3.0,\"earningRate\":1.41},{\"assetType\":\"BOND\",\"assetName\":\"예보기금특별계정채권2012-10\",\"qty\":3.0,\"earningRate\":2.76},{\"assetType\":\"BOND\",\"assetName\":\"한국지역난방공사13-1\",\"qty\":3.0,\"earningRate\":1.73},{\"assetType\":\"BOND\",\"assetName\":\"주택금융공사MBS2016-10(1-4)\",\"qty\":3.0,\"earningRate\":1.33},{\"assetType\":\"BOND\",\"assetName\":\"주택금융공사MBS2016-7(1-5)\",\"qty\":6.0,\"earningRate\":2.88},{\"assetType\":\"BOND\",\"assetName\":\"강원도개발공사121\",\"qty\":3.0,\"earningRate\":0.19},{\"assetType\":\"BOND\",\"assetName\":\"한국장학재단15-43\",\"qty\":3.0,\"earningRate\":5.68},{\"assetType\":\"BOND\",\"assetName\":\"한국장학재단15-28\",\"qty\":3.0,\"earningRate\":4.36},{\"assetType\":\"BOND\",\"assetName\":\"토지주택채권(토지수익연계채권)\",\"qty\":0.0,\"earningRate\":22.87},{\"assetType\":\"BOND\",\"assetName\":\"토지주택채권294\",\"qty\":3.0,\"earningRate\":3.99},{\"assetType\":\"BOND\",\"assetName\":\"산금(정금)12신이0500-0320-1\",\"qty\":3.0,\"earningRate\":2.09},{\"assetType\":\"BOND\",\"assetName\":\"농업금융채권(은행)2013-02이5Y-\",\"qty\":3.0,\"earningRate\":3.04},{\"assetType\":\"BOND\",\"assetName\":\"스탠다드차타드은행13-05-이(콜)\",\"qty\":6.0,\"earningRate\":2.34},{\"assetType\":\"BOND\",\"assetName\":\"GS칼텍스130-1\",\"qty\":3.0,\"earningRate\":4.18},{\"assetType\":\"BOND\",\"assetName\":\"SK텔레콤61-1\",\"qty\":3.0,\"earningRate\":1.34},{\"assetType\":\"BOND\",\"assetName\":\"KT181-1\",\"qty\":3.0,\"earningRate\":-2.21},{\"assetType\":\"BOND\",\"assetName\":\"신한금융지주81-1\",\"qty\":3.0,\"earningRate\":3.31},{\"assetType\":\"BOND\",\"assetName\":\"한국서부발전16-1\",\"qty\":3.0,\"earningRate\":1.65},{\"assetType\":\"BOND\",\"assetName\":\"LG전자73-4\",\"qty\":3.0,\"earningRate\":3.55},{\"assetType\":\"BOND\",\"assetName\":\"BNK금융 조건부(상)1-1\",\"qty\":1.0,\"earningRate\":8.39},{\"assetType\":\"BOND\",\"assetName\":\"부산교통공사2014-02\",\"qty\":3.0,\"earningRate\":5.52},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-2\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-6\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-7\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-8\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-9\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-10\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-11\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-12\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-14\",\"qty\":0.0,\"earningRate\":0.86},{\"assetType\":\"CP\",\"assetName\":\"루카스 20131227-89-15\",\"qty\":0.0,\"earningRate\":0.86}]}]},\"resp\":{\"respCode\":\"200\",\"respMsg\":\"OK\"}}";
        Gson gson = new Gson();
        PortfolioResponse portfolioResponse = gson.fromJson(jsonMsg, PortfolioResponse.class);

        CommonHeader commonHeader = portfolioResponse.getCommonHeader();
        System.out.println("-------------------------------------");
        System.out.println("DN = "+ commonHeader.getCertDn());

        PortfolioResponseBody portfolioResponseBody = portfolioResponse.getPortfolioResponseBody();
        AccInfo accInfo  = portfolioResponseBody.getAccInfo();

        System.out.println("실계좌번호 = "+accInfo.getRealAccNo());
        System.out.println("가상계좌번호 = "+accInfo.getVtAccNp());

        QueryResult queryResult = portfolioResponseBody.getQueryResult();
        System.out.println("-------------------------------------");
        System.out.println("조회결과:총건수= "+queryResult.getTotalCnt());
        System.out.println("조회결과:금번건수= "+queryResult.getCount());
        if (queryResult.getPage().equals("null")) {
            System.out.println("더이상 조회할 페이지가 없습니다.");
        }else {
            System.out.println("다음 페이지의 키 = ["+queryResult.getPage()+"]");
        }
        PortfolioList portfolioList = portfolioResponse.getPortfolioList();

        JsonParser parser = new JsonParser();
        JsonObject data = parser.parse(jsonMsg).getAsJsonObject().getAsJsonObject("portfolioList");
        JsonArray array = data.getAsJsonArray("portfolio");
        int equityCnt =0, fundCnt =0, etcCnt = 0;
        for (JsonElement je1 : array) {
            if (je1.getAsJsonObject().get("cash") != null) {
                Amount amt = gson.fromJson(je1.getAsJsonObject().get("cash"), Amount.class);
                System.out.println("-------------------------------------");
                System.out.println("계좌내현금 - "+amt.getAmt());
            } else if (je1.getAsJsonObject().get("equityList") !=null) {
                Type listType = new TypeToken<ArrayList<Equity>>(){}.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("equityList"), listType);
                System.out.println("-------------------------------------");
                equityCnt = arrayList.size();
                System.out.println("Equity 상품군 종목수 = ["+equityCnt+"]");
                for(Object object : arrayList) {
                    Equity equity = (Equity)object;
                    System.out.println("-------------------------------------");
                    System.out.println("상품구분 - [" + equity.getAssetType() +"]");
                    System.out.println("종목코드 - [" + equity.getIsinCode()+"]");
                    System.out.println("보유비율 - [" + equity.getQty()+"]");
                    System.out.println("수익률 - [" + equity.getEarningRate()+"]");
                }
            } else if (je1.getAsJsonObject().get("fundList") !=null) {
                Type listType = new TypeToken<ArrayList<Fund>>(){}.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("fundList"), listType);
                System.out.println("-------------------------------------");
                fundCnt = arrayList.size();
                System.out.println("fundList 상품군 종목수 = ["+fundCnt+"]");
                for(Object object : arrayList) {
                    Fund fund = (Fund)object;
                    System.out.println("-------------------------------------");
                    System.out.println("펀드코드 - [" + fund.getFundCode() +"]");
                    System.out.println("펀드이름 - [" + fund.getFundName()+"]");
                    System.out.println("보유수량 - [" + fund.getQty()+"]");
                    System.out.println("수익률 - [" + fund.getEarningRate()+"]");
                    System.out.println("만기일 - [" + fund.getMaturity()+"]");
                }
            } else if (je1.getAsJsonObject().get("etcList") !=null) {
                Type listType = new TypeToken<ArrayList<Etc>>(){}.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("etcList"), listType);
                System.out.println("-------------------------------------");
                etcCnt = arrayList.size();
                System.out.println("etcList 상품군 종목수 = ["+etcCnt+"]");
                for(Object object : arrayList) {
                    Etc etc = (Etc)object;
                    System.out.println("-------------------------------------");
                    System.out.println("상품구분 - [" + etc.getAssetType() +"]");
                    System.out.println("상품이름 - [" + etc.getAssetName()+"]");
                    System.out.println("보유수량 - [" + etc.getQty()+"]");
                    System.out.println("수익률 - [" + etc.getEarningRate()+"]");
                }
            }
        }
        {
            int totalCntInMsg = equityCnt + fundCnt + etcCnt;
            System.out.println("-------------------------------------");
            System.out.println("이번 메시지 내 총 종목건수 - [" + totalCntInMsg+"]");
            if (totalCntInMsg - queryResult.getCount() != 0) {
                System.out.println("보낼 종목수와 받은 종목수가 차이가 있음");
            }
        }
    }
}
