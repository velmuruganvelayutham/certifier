# Deploy the scrap-jar in the repo folder.

mvn deploy:deploy-file -Durl=file:///home/velmuruganv/Documents/workspace-sts-3.6.0.RELEASE/trade-show/repo -Dfile=/home/velmuruganv/jsoup/target/scraper-1.7.4-SNAPSHOT-jar -DgroupId=com.tocgroup -DartifactId=scraper -Dpackaging=jar -Dversion=1.7.4-SNAPSHOT


