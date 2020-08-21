import 'package:flutter/foundation.dart';
import 'package:flutter_app/flutter_app.dart';

@pragma('vm:entry-point')
void main(List<String> args) {
  if (kReleaseMode) {
    startApp(appFlavor: 'prod');
  } else {
    startApp(appFlavor: 'dev');
  }
}

@pragma('vm:entry-point')
void mainDev() => startApp(appFlavor: 'dev');

@pragma('vm:entry-point')
void mainSandbox() => startApp(appFlavor: 'sandbox');

@pragma('vm:entry-point')
void mainProd() => startApp(appFlavor: 'prod');
